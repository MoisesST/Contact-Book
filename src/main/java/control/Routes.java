package control;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.Spark.staticFiles;

import spark.template.velocity.VelocityTemplateEngine;

import controllers.ContactController;

public class Routes {

  public static void myRoutes() {

    VelocityTemplateEngine engine = new VelocityTemplateEngine();

    staticFiles.location("/public");
    get("/", ContactController::home, engine);
    get("/", ContactController::listContacts, engine); // engine renderiza a pag
    get("/contact/:id", ContactController::getContactById, engine);
    // get("/contacts/new", ContactController::pageNew, engine);
    post("/contacts", ContactController::createContact);
    put("/contact/:id", ContactController::updateContact);
    delete("/contact/:id", ContactController::deleteContact);
  }
}