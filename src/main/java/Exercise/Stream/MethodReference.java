package Exercise.Stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/9/13
 */
public class MethodReference {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("c", "c");


        map.merge("b", "autoValue", (a, b) -> a + b);
        map.merge("a", "autoValue", (a, b) -> a + b);
        map.merge("c", "distValue", String::concat);

        System.out.println(map);
    }
}
