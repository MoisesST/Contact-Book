package control;

import static spark.Spark.*;

import spark.template.velocity.VelocityTemplateEngine;

import controllers.ContactController;

public class Routes {

  public static void myRoutes() {
    VelocityTemplateEngine engine = new VelocityTemplateEngine();
    staticFiles.location("/public");
    get("/", ContactController::pageHome, engine);
    get("/contact/:id", ContactController::pageDetail, engine);
    get("/contacts/new", ContactController::pageNew, engine);
    post("/contacts", ContactController::createContact);
    // get("/contacts/new", ContactController::newContact, engine);
    // get("/x", ContactController::listContacts, engine); // engine renderiza a pag
    // get("/contact/:id", ContactController::getContactById, engine);
    // put("/contact/:id", ContactController::updateContact);
    // delete("/contact/:id", ContactController::deleteContact);
  }
}