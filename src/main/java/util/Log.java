package util;

import java.util.ArrayList;
import java.util.Iterator;

public class Log implements Error {

  private ArrayList<String> errors;

  public Log() {
    errors = new ArrayList<>();
  }

  public void addErro(String error) {
    errors.add(error);
  }

  public void showAllErrors() {
    Iterator<String> iterator = errors.iterator();
    while (iterator.hasNext())
      System.out.println(iterator.next());
  }
}
