package Exercise.MetricsV1;

public class MetricsCollector {
    private MetricsStorage metricsStorage;

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if(requestInfo == null || requestInfo.getApiName().isEmpty()) {
            return;
        }

        metricsStorage.saveRequestInfo(requestInfo);
    }
}
