package concurrency;//: concurrency/LiftOff.java
// Demonstration of the Runnable interface.

public class LiftOff implements Runnable {
  protected int countDown = 10; // Default
  private static int taskCount = 0;
  private final int id = taskCount++;
  public LiftOff() {}
  public LiftOff(int countDown) {
    this.countDown = countDown;
  }
  public String status() {
    return "#" + id + "(" +
      (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }

  @Override
  public void run() {
    while(countDown-- > 0) {
      System.out.print(status());
      Thread.yield();
    }
  }
} ///:~


class DemoThread {
  public static void main(String[] args) {
      for (int i = 0; i < 5; i++) {
        Thread t = new Thread(new LiftOff());
        t.start();
      }
    System.out.println("Waiting for LiftOff");
  }
}