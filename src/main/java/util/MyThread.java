package util;

public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
    start();
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}