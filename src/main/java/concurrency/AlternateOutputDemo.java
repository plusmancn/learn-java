package concurrency;

/**
 * concurrence
 *
 * @author plusman
 * @since 2020/11/21
 */
public class AlternateOutputDemo {
    public static volatile int i = 0;
    public static void main(String[] args) {
        JoinThread t1 = new JoinThread("T1", 1000);
        JoinThread t2 = new JoinThread("T2", 1000);
        t1.setT(t2);
        t2.setT(t1);

        t1.start();
        t2.start();
    }
}

class JoinThread extends Thread {
    private Thread t;
    private String name;
    private int duration;

    public void setT(Thread t) {
        this.t = t;
    }

    public JoinThread(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
    @Override
    public void run() {
        while (AlternateOutputDemo.i < 10) {
            System.out.println(this.name  + ": " + AlternateOutputDemo.i++);
            Thread.yield();
        }
    }
}

