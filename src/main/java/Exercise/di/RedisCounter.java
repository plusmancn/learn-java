package Exercise.di;

public class RedisCounter {
    private String ipAddress;
    private String port;
    public RedisCounter(String ipAddress, String port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public int increamentAndGet() {
        System.out.println("Connect to " + this.ipAddress + ":" + this.port);
        return 10;
    }
}
