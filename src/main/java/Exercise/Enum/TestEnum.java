package Exercise.Enum;

enum  Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRALARGE("XL");

    private final String value;

    Size(String name) {
        this.value = name;
    }

    public static Size fromValue(String value) {
        if (value != null) {
            for(Size size : values()) {
                if (size.value.equals(value)) {
                    return size;
                }
            }
        }

        throw new IllegalArgumentException("Invalid Color: " + value);
    }

    public String toValue() {
        return this.value;
    }
}

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Size.SMALL);
        System.out.println(Size.MEDIUM);

        System.out.println(Size.fromValue("XLL"));
    }
}
