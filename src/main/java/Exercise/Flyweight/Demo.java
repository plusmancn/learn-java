package Exercise.Flyweight;

public class Demo {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(56);
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
    }
}
