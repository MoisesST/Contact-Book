package util;

public enum MessagesToUsers {
  ERROR(1, "Error"),
  SUCCESS(2, "Success"),
  WARNING(3, "Warning");

  private int position;
  private String message;

  MessagesToUsers(int position, String message) {
    this.message = message;
    this.position = position;
  }

  public int getPosition() { return position; }

  public String getMessage() { return message; }
}

