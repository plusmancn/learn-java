package Exercise.Flyweight;

public class Demo2 {
    public static void main(String[] args) {
        String s1 = "小争哥";
        String s2 = String.valueOf("小争哥");
        String s3 = new String("小争哥");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
