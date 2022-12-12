package controllers;

import spark.*;
import java.util.*;
import util.*;
import model.*;
import dao.*;

public class ContactController {

  private static MessagesToUsers msg;

  private static Log log = new Log();

  public static ModelAndView pageNew(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    return new ModelAndView(model, "view/new.vm");
  }

  public static Object createContact(Request req, Response res) {
    GenericDAO<Contact> dao = new GenericDAO<Contact>();
    try {
      dao.save(new Contact(
          req.queryParams("name"),
          req.queryParams("phone")));
    } catch (Exception e) {
      log.addErro("deu craps na gravação do banco");
      log.showAllErrors();
      return ("Internal Server Craps");
    }
    res.redirect("/contacts");
    MessagesToUsers msg = MessagesToUsers.SUCCESS;
    return msg.getMessage();
  }

  public static ModelAndView pageContacts(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    GenericDAO<Contact> dao = new GenericDAO<Contact>();
    try {
      model.put("contacts", dao.listAll(new Contact()));
    } catch (Exception e) {
      e.printStackTrace();
      return new ModelAndView(model, "view/error.vm");
    }
    return new ModelAndView(model, "view/contacts.vm");
  }

  public static ModelAndView pageDetail(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    ContactDAO dao = new ContactDAO();
    int id = Integer.parseInt(req.params("id"));
    try {
      model.put("contact", dao.getContactById(id));
    } catch (Exception e) {
      e.printStackTrace();
      return new ModelAndView(model, "view/error.vm");
    }
    return new ModelAndView(model, "view/detail.vm");
  }
}