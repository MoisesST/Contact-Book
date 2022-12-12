package controllers;

import spark.*;
import java.util.*;

public class PageController {

  public static ModelAndView pageHome(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    return new ModelAndView(model, "view/home.vm");
  }
}
