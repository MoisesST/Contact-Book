package model;

public class Administrator extends Person {

  private int id;

  public Administrator(String name) {
    super(name);
  }

  public int getId() {
    return id;
  }
}
