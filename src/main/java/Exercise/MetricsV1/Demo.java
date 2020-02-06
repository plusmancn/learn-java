package Exercise.MetricsV1;

public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage();
        MetricsCollector collector = new MetricsCollector(storage);

        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        ConsoleReporter consoleReporter = new ConsoleReporter(storage, new Aggregator(), new ConsoleViewer());
        consoleReporter.startRepeatedReport(10, 10);

        // try {
        //     Thread.sleep(100000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
    }
}
