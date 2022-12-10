package util;

public class Validator {

  private Validator() {}

  public static void message(String msg) {
    if (msg == null)
      throw new NullException("Mensagem nula!");

    if (msg.trim().isEmpty())
      throw new EmptyException(msg);
  }
}
