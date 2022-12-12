package controllers;

import java.text.SimpleDateFormat;
import java.util.*;
import spark.*;

public class TimeController extends Thread {

  public static ModelAndView pageTime(Request req, Response res) {
    HashMap<String, Object> model = new HashMap();
    model.put("time", new SimpleDateFormat(
      "yyyy/MM/dd HH:mm:ss").format(
          Calendar.getInstance().getTime()));
    return new ModelAndView(model, "view/time.vm");
  }
}