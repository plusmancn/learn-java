package concurrency;//: concurrency/AtomicityTest.java
import java.util.concurrent.*;

public class AtomicityTest implements Runnable {
  private volatile int i = 0;
  public synchronized int getValue() { return i; }
  private synchronized void evenIncrement() {
    i++;
    i++;
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  @Override
  public void run() {
    while(true) {
      evenIncrement();
      Thread.yield();
    }
  }
  public static void main(String[] args) {
    ExecutorService exec = Executors.newCachedThreadPool();
    AtomicityTest at = new AtomicityTest();
    exec.execute(at);
    while(true) {
      int val = at.getValue();
      if(val % 2 != 0) {
        System.out.println(val);
        System.exit(0);
      } else {
        System.out.println(val);
      }
    }
  }
} /* Output: (Sample)
191583767
*///:~
