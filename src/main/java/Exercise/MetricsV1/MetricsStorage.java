package Exercise.MetricsV1;

import java.util.List;
import java.util.Map;

public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMills, long endTimeInMills);
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMills, long endTimeInMills);
}

