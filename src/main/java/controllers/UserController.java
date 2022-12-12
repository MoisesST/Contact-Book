package controllers;

import java.util.*;

import dao.*;
import spark.*;
import model.*;
import util.*;

public class UserController {

  private static MessagesToUsers msg;

  private static Log log = new Log();

  public static ModelAndView pageLogin(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    return new ModelAndView(model, "view/login.vm");
  }

  public static ModelAndView pageCreateAccount(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    return new ModelAndView(model, "view/create-account.vm");
  }

  public static Object loginUser(Request req, Response res) {
    UserDAO userDAO = new UserDAO();
    for (User user : userDAO.listAllUsers()) {
      if (user.getEmail().equals(req.queryParams("email"))
          && user.getPassword().equals(req.queryParams("password"))) {
        res.redirect("/contacts");
        msg = MessagesToUsers.SUCCESS;
        return msg.getMessage();
      }
    }
    msg = MessagesToUsers.ERROR;
    return msg.getMessage();
  }

  public static Object createUser(Request req, Response res) {
    UserDAO userDAO = new UserDAO();
    User user = new User(
        req.queryParams("name"),
        req.queryParams("email"),
        req.queryParams("phone"),
        req.queryParams("password"));

    try {
      userDAO.createUser(user);
    } catch (Exception e) {
      log.addErro("deu craps na gravação do banco");
      log.showAllErrors();
      return ("Internal Server Craps");
    }
    res.redirect("/contacts");
    MessagesToUsers msg = MessagesToUsers.SUCCESS;
    return msg.getMessage();
  }
}