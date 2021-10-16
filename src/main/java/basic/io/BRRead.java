package basic.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author plusman
 * @since 2021/10/16 1:20 PM
 */
public class BRRead {
    public Integer a;
    
    {
        a = 12;
    }
    
    public static void main(String[] args) throws IOException {
        BRRead brRead = new BRRead();
        System.out.println(brRead.a);
        
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
