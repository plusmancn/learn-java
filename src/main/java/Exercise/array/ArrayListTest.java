package Exercise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("C", "D");
        list.add("xx");
        System.out.println(list);

        List<String> listb = new ArrayList<>(list);
        listb.add("E");
        System.out.println(listb);
    }
}