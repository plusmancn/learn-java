package Exercise.TemplateRender;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Exercise.TemplateRender
 *
 * @author plusman
 * @since 2020/9/11
 */
public class RegexpImpl {
    public static void main(String[] args) {
        String template = "你的验证码是 {code}, 请在 {time} 分钟使用 {la}\n" +
            "第二行，也有 {call}";
        Map<String, String> params = new HashMap<>();
        params.put("code", "8991");
        params.put("time", "10");


        System.out.println(renderTemplate(template, params));
    }

    public static String renderTemplate(String template, Map<String, String> params) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("(?im)\\{(\\w+)\\}$");
        Matcher m = p.matcher(template);
        while (m.find()) {
            String value = params.get(m.group(1));
            m.appendReplacement(sb, value == null ? "" : value);
        }

        m.appendTail(sb);
        return sb.toString();
    }
}
