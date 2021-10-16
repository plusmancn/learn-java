package basic.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author plusman
 * @since 2021/10/16 5:53 PM
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        // TODO 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(3333);
        
        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
    
                    System.out.println("Accpet a new socket: " + socket);
                    
                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            OutputStream outputStream  = socket.getOutputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                                outputStream.write("Pong".getBytes());
                            }
                        } catch (IOException e) {
                        }
                    }).start();
                    
                } catch (IOException e) {
                }
                
            }
        }).start();
        
    }
}
