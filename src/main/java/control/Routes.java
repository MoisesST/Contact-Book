package control;

import static spark.Spark.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import spark.template.velocity.VelocityTemplateEngine;

import controllers.*;

public class Routes {

  public static void myRoutes() {
    VelocityTemplateEngine engine = new VelocityTemplateEngine();
    staticFiles.location("/public");
    get("/", PageController::pageHome, engine);
    get("/users/login", UserController::pageLogin, engine);
    post("/users/login", UserController::loginUser);
    get("/users/new", UserController::pageCreateAccount, engine);
    post("/users", UserController::createUser);
    get("/contacts", ContactController::pageContacts, engine);
    get("/contacts/new", ContactController::pageNew, engine);
    post("/contacts", ContactController::createContact);
    get("/contact/:id", ContactController::pageDetail, engine);
    Thread t0 = new Thread(() -> {
      try {
        for (int i = 0; i < 3; i++) {
          Thread.sleep(4000);
          System.out.println(Thread.currentThread().getName());
          String t = new SimpleDateFormat(
              "yyyy/MM/dd HH:mm:ss").format(
                  Calendar.getInstance().getTime());
          System.out.println(t);
          get("/time", TimeController::pageTime, engine);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    t0.start();
  }
}