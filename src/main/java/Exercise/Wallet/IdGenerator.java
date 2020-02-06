package Exercise.Wallet;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

// 可以考虑定义为接口
public class IdGenerator {
    // 不参与业务逻辑执行，所以不需要依赖注入，可以为 static final
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    /**
     * 从单元测试触发考虑
     * @return 需要明确返回组成
     */
    public static String generate() {
        String id = "";
        try {
            // 提取函数 fetchHostNameLastPart
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] tokens = hostName.split("\\.");
            if (tokens.length > 0) {
                hostName = tokens[tokens.length - 1];
            }

            // 非空未处理


            char[] randomChars = new char[8];
            int count = 0;
            Random random = new Random();
            // 字符集可以是一个数组，一来提高性能，二来简化代码
            while (count < 8) {
                int randomAscii = random.nextInt(122);
                if (randomAscii >= 48 && randomAscii <= 57) {
                    randomChars[count] = (char)('0' + (randomAscii - 48));
                    count++;
                } else if (randomAscii >= 65 && randomAscii <= 90) {
                    randomChars[count] = (char)('A' + (randomAscii - 65));
                    count++;
                } else if (randomAscii >= 97 && randomAscii <= 122) {
                    randomChars[count] = (char)('a' + (randomAscii - 97));
                    count++;
                }
            }


            id = String.format("%s-%d-%s", hostName,
                    System.currentTimeMillis(), new String(randomChars));
        } catch (UnknownHostException e) {
            // 是否应该抛出错误
            logger.warn("Failed to get the host name.", e);
        }

        return id;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 4; i++) {
            System.out.println(IdGenerator.generate());
        }
    }
}

class FinalTest {
    public static void main(String[] args)  {
        String a = "hello2";
        final String b = "hello";
        String d = "hello";
        String c = b + 2;
        String e = d + 2;

        System.out.println((a == c));
        System.out.println((a == e));
    }
}