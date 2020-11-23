package Exercise.guavademo;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

import java.util.concurrent.TimeUnit;

/**
 * Exercise.guavademo
 *
 * @author plusman
 * @since 2020/11/15
 */
public class CacheDemo {
    public static void main(String[] args) throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
            .initialCapacity(100)
            .maximumSize(1000)
            .expireAfterWrite(2, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return null;
                }
            });

        cache.put("key1", "value1");
        System.out.println(cache.getIfPresent("key1"));
        Thread.sleep(3000);
        System.out.println(cache.getIfPresent("key1"));


        // ParameterTyp<Integer> p = ParameterTypBuilder.newBuilder()
        //     .build();
        //
        // p.setV(13);
        // p.setV("hello");
        // System.out.println(p.getV());
    }
}


class ParameterTyp<T> {
    T v;

    public void setV(T v) {
        this.v = v;
    }

    public T getV() {
        return v;
    }
}

class ParameterTypBuilder {
    public static ParameterTypBuilder newBuilder() {
        return new ParameterTypBuilder();
    }

    public ParameterTyp build() {
        return new ParameterTyp<>();
    }
}
