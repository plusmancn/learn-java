package Exercise.Stream;

import com.google.common.base.CaseFormat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise.Stream
 *
 * @author plusman
 * @since 2020/11/20
 */
public class SnakeCaseToCamelCaseDemo {
    public static void main(String[] args) {
        System.out.println(convert("hello_world"));
        System.out.println(myConvert("hello_world"));
    }

    public static String convert(String s) {
        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, s);
    }


    private final static Pattern pattern = Pattern.compile("\\_(\\w)");
    public static String myConvert(String s) {
        StringBuffer sb = new StringBuffer();

        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        return sb.toString();
    }
}
