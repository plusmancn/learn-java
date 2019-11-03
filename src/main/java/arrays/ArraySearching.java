package arrays;//: arrays/ArraySearching.java
// Using Arrays.binarySearch().
import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class ArraySearching {
  public static void main(String[] args) {
    Generator<Integer> gen =
      new RandomGenerator.Integer(1000);
    Integer[] b = Generated.array(new Integer[25], gen);
    Arrays.sort(b);

    int[] a = ConvertTo.primitive(b);

    print("Sorted array: " + Arrays.toString(a));
    while(true) {
      int r = gen.next();
      int location = Arrays.binarySearch(a, r);
      if(location >= 0) {
        print("Location of " + r + " is " + location +
          ", a[" + location + "] = " + a[location]);
        break; // Out of while loop
      }
    }

    int[] c = {-3, -2, -1};
    print(Arrays.binarySearch(c, -2));

    // >>> 是无符号位移
    print(2 >>> 1);
    print(-2 >>> 1);
    // 保留高位的位移
    print(-2 >> 1);
  }
} /* Output:
Sorted array: [128, 140, 200, 207, 258, 258, 278, 288, 322, 429, 511, 520, 522, 551, 555, 589, 693, 704, 809, 861, 861, 868, 916, 961, 998]
Location of 322 is 8, a[8] = 322
*///:~
