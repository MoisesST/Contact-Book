package util;

public class EmptyException extends RuntimeException {

  private String msg;

  public EmptyException(String msg) {
    this.msg = msg;
  }

  public String getMessage() {
    return String.format("Não aceita argumento vazio: '%s'.", msg);
  }
}
