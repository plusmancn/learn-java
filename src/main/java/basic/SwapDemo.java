package basic;

/**
 * @author plusman
 * @since 2021/10/16 11:55 AM
 */
public class SwapDemo {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;
        String c = "hello";
        
        swap(num1, num2, c);
        
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("c=" + c);
    }
    
    private static void swap(int a, int b, String c) throws NoClassDefFoundError {
        int temp = a;
        a = b;
        b = temp;
        c = "world";
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c=" + c);
    }
}
