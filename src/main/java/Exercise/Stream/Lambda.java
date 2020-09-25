package Exercise.Stream;

import java.util.*;
import java.util.function.DoubleBinaryOperator;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/9/13
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> words = new LinkedList<>();
        words.add("hello");
        words.add("ambulance");
        words.add("world");

        words.sort(Comparator.comparingInt(String::length));

        System.out.println(words);
        System.out.println(Operation.PLUS.apply(29, 39));
        System.out.println(OperationLamda.PLUS.apply(29, 59));
    }

    enum Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x +y; }
        };

        private final String symbol;
        Operation(String symbol) { this.symbol = symbol; }

        @Override
        public String toString() {
            return symbol;
        }

        public abstract double apply(double x, double y);
    }

    enum OperationLamda {
        PLUS("+", (x, y) -> x + y);

        private final String symbol;
        private final DoubleBinaryOperator op;
        OperationLamda(String symbol, DoubleBinaryOperator op) {
            this.symbol = symbol;
            this.op = op;
        }

        public double apply(double x, double y) {
            return op.applyAsDouble(x, y);
        }
    }

}
