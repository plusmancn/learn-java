package basic.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author plusman
 * @since 2021/10/16 5:53 PM
 */
public class IOClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    int len;
                    byte[] data = new byte[1024];
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                        if ((len = socket.getInputStream().read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
        
    }
}
