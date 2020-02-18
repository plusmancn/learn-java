package Exercise.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BackendServer {
    private long serverNo;
    private String serverAddress;

    private static final int SERVER_COUNT = 3;
    private static final Map<Long, BackendServer> serverInstances = new HashMap<>();

    static  {
        serverInstances.put(1L, new BackendServer(1L, "192.168.1.1:8080"));
        serverInstances.put(2L, new BackendServer(2L, "192.168.1.2:8080"));
        serverInstances.put(3L, new BackendServer(2L, "192.168.1.3:8080"));
    }

    public BackendServer(long serverNo, String serverAddress) {
        this.serverNo = serverNo;
        this.serverAddress = serverAddress;
    }

    public static BackendServer getInstance(long serverNo) {
        return serverInstances.get(serverNo);
    }

    public static BackendServer getRandomInstance() {
        Random random = new Random();
        long pos = random.nextInt(SERVER_COUNT + 1);
        return serverInstances.get(pos);
    }

    public static void main(String[] args) {
        BackendServer.getRandomInstance();
    }
}
