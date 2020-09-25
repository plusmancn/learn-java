package Exercise.Stream;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/9/14
 */
public class StreamTest {
    public static enum Color {
        RED,
        BLUE,
        WHITE,
        PURPLE
    }


    public static class Widget {
        private Color color;
        private Integer weight;

        public Widget(Color color, Integer weight) {
            this.color = color;
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public Integer getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "Widget{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
        }
    }

    public static void main(String[] args) {
        // interferenceExample();
        // traverseExample();
        // LazyExample();
    }

    public static void log (Object... objects) {
        String s = LocalTime.now().toString();
        for (Object object : objects) {
            s += " - " + object.toString();
        }
        System.out.println(s);
        // putting a little delay so that we can see a clear difference
        // with parallel stream.
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void LazyExample() {
        IntStream stream = IntStream.range(1, 5);
        stream = stream.peek(i -> log("starting", i))
            .filter(i -> {
                log("filtering", i);
                return i % 2 == 0;
            })
            .peek(i -> log("post filtering", i));

        log("Invoking terminal method count.");
        log("The count is", stream.count());
    }

    public static void traverseExample() {
        // 初始化数据
        Collection<Widget> widgets = new LinkedList<>();
        widgets.add(new Widget(Color.BLUE, 10));
        widgets.add(new Widget(Color.RED, 11));
        widgets.add(new Widget(Color.WHITE, 12));
        widgets.add(new Widget(Color.RED, 12));
        widgets.add(new Widget(Color.BLUE, 10));
        widgets.add(new Widget(Color.RED, 11));
        widgets.add(new Widget(Color.WHITE, 12));
        widgets.add(new Widget(Color.RED, 12));
        widgets.add(new Widget(Color.BLUE, 10));
        widgets.add(new Widget(Color.RED, 11));
        widgets.add(new Widget(Color.WHITE, 12));
        widgets.add(new Widget(Color.RED, 12));

        // JS 写法，香啊
        int sum = widgets.stream()
            .filter(a -> {
                log("filter", a);
                return a.getColor() == Color.RED;
            })
            .mapToInt(a -> {
                log("mapToInt", a);
                return  a.getWeight();
            })
            .sum();
        System.out.println(sum);

        int sum2 = widgets.parallelStream().sequential()
            .filter(a -> {
                log("parallel.filter", a);
                return a.getColor() == Color.RED;
            })
            .mapToInt(a -> {
                log("parallel.mapToInt", a);
                return  a.getWeight();
            })
            .sum();
        System.out.println(sum2);
    }

    public static void interferenceExample() {
        List<String> l = new ArrayList<>(Arrays.asList("one", "tow"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(Collectors.joining(" j"));
        System.out.println(s);
    }
}
