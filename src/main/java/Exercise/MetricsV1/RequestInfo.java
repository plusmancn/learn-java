package Exercise.MetricsV1;

public class RequestInfo {
    private String apiName;
    private long responseTime;
    private long timestamp;

    public RequestInfo(String apiName, long responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
