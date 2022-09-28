package controllers;

import java.util.HashMap;

import model.Contact;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import dao.GenericDao;

public class ContactController {

  public static ModelAndView home(Request req, Response res) {

    HashMap<String, Object> model = new HashMap();

    return new ModelAndView(model, "view/home.vm");
  }

  public static ModelAndView listContacts(Request req, Response res) {

    HashMap<String, Object> model = new HashMap();

    GenericDao<Contact> genericDao = new GenericDao<Contact>();

    Contact contact = new Contact();

    model.put("contacts", genericDao.listAll(contact));

    return new ModelAndView(model, "view/contacts.vm");
  }

  public static ModelAndView getContactById(Request req, Response res) {

    HashMap<String, Object> model = new HashMap();

    GenericDao<Contact> genericDao = new GenericDao<Contact>();

    Contact contact = new Contact();

    int idreq = Integer.parseInt(req.params("id"));

    try {

      contact = genericDao.getObjectById(contact, idreq);

    } catch (Exception e) {

      System.out.println("deu craps da leitura do banco");
    }
    model.put("contact", contact);

    return new ModelAndView(model, "view/detail.vm");
  }

  // public static ModelAndView pageNew(Request req, Response res) {

  // HashMap<String, Object> model = new HashMap();

  // return new ModelAndView(model, "view/new.vm");
  // }

  public static Object createContact(Request req, Response res) {

    String name = req.queryParams("name");
    String phone = req.queryParams("phone");
    String email = req.queryParams("email");

    Contact contact = new Contact();

    contact.setName(name);
    contact.setPhone(phone);
    contact.setEmail(email);

    GenericDao<Contact> dao = new GenericDao<Contact>();

    try {

      dao.save(contact);

    } catch (Exception e) {

      System.out.println("deu craps na gravação do banco");

      return ("Internal Server Craps");
    }

    res.redirect("/");

    return "ok";
  }

  public static Object updateContact(Request req, Response res) {

    return "ok";
  }

  public static Object deleteContact(Request req, Response res) {

    return "ok";
  }
}