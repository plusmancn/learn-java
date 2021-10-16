package basic;

/**
 * @author plusman
 * @since 2021/10/16 12:37 PM
 */
public class FinalTest {
    public static void main(String[] args) {
        System.out.println(f(2));
    }
    
    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}
