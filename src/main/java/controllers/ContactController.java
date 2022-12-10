package controllers;

import spark.*;
import util.*;
import java.util.HashMap;
import model.Contact;
import dao.ContactDAO;
import dao.GenericDao;

public class ContactController {

  private static GenericDao<Contact> genericDao = null;

  private static Log log = new Log();

  public static ModelAndView pageHome(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    genericDao = new GenericDao<Contact>();
    try {
      model.put("contacts", genericDao.listAll(new Contact()));
    } catch (Exception e) {
      e.printStackTrace(); // or return an error page
    }
    return new ModelAndView(model, "view/home.vm");
  }

  public static ModelAndView pageDetail(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    ContactDAO contactDAO = new ContactDAO();
    int id = Integer.parseInt(req.params("id"));
    try {
      model.put("contact", contactDAO.getContactById(id));
    } catch (Exception e) {
      e.printStackTrace(); // or return an error page
    }
    return new ModelAndView(model, "view/detail.vm");
  }

  public static ModelAndView pageNew(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    return new ModelAndView(model, "view/new.vm");
  }

  public static Object createContact(Request req, Response res) {
    GenericDao<Contact> dao = new GenericDao<Contact>();
    try {
      dao.save(new Contact(
          req.queryParams("name"),
          req.queryParams("phone"),
          req.queryParams("email")));
    } catch (Exception e) {
      log.addErro("deu craps na gravação do banco");
      log.showAllErrors();
      return ("Internal Server Craps");
    }
    res.redirect("/");
    MessagesToUsers msg = MessagesToUsers.SUCCESS;
    return msg.getMessage();
    // return "ok";
  }

  // public static ModelAndView home(Request req, Response res) {
  // HashMap<String, Object> model = new HashMap();
  // return new ModelAndView(model, "view/home.vm");
  // }

  // não está funcionando
  // public static ModelAndView pageDetail(Request req, Response res) {
  // HashMap<String, Object> model = new HashMap();
  // genericDao = new GenericDao<Contact>();
  // int id = Integer.parseInt(req.params("id"));
  // try {
  // model.put("contact", genericDao.getObjectById(new Contact(), id));
  // } catch (Exception e) {
  // e.printStackTrace(); // or return an error page
  // }
  // return new ModelAndView(model, "view/detail.vm");
  // }

  // public static ModelAndView getContactById(Request req, Response res) {
  // HashMap<String, Object> model = new HashMap();
  // genericDao = new GenericDao<Contact>();
  // Contact contact = new Contact();
  // int idreq = Integer.parseInt(req.params("id"));
  // try {
  // contact = genericDao.getObjectById(contact, idreq);
  // } catch (Exception e) {
  // log.addErro("deu craps da leitura do banco");
  // log.showAllErrors();
  // }
  // model.put("contact", contact);
  // return new ModelAndView(model, "view/detail.vm");
  // }

  // public static Object updateContact(Request req, Response res) {

  // return "ok";
  // }

  // public static Object deleteContact(Request req, Response res) {

  // return "ok";
  // }
}