package Exercise.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Metrics {
    private Map<String, List<Double>> responseTime = new HashMap<>();
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void startRepeatedReport(long period) {
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        }, 0 , period, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        Metrics m = new Metrics();
        m.startRepeatedReport(12);
    }
}
