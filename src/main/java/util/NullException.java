package util;

public class NullException extends RuntimeException {

  private String msg;

  public NullException(String msg) {
    this.msg = msg;
  }

  public String getMessage() {
    return String.format("Não aceita argumento nulo: '%s'.", msg);
  }
}