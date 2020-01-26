package Exercise.MetricsV1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RedisMetricsStorage implements MetricsStorage{
    Map<String, List<RequestInfo>> apiSet = new HashMap<>();

    @Override
    public void saveRequestInfo(RequestInfo requestInfo) {
        apiSet.putIfAbsent(requestInfo.getApiName(), new LinkedList<>());
        apiSet.get(requestInfo.getApiName()).add(requestInfo);
    }

    @Override
    public List<RequestInfo> getRequestInfos(String apiName, long startTimeInMills, long endTimeInMills) {
        return apiSet.get(apiName);
    }

    @Override
    public Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills) {
        return apiSet;
    }
}
