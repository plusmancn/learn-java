package Exercise.io;

import java.io.*;

public class FileTest {
    public static void main(String[] args) {
        try {
            System.out.println("CWD: " + System.getProperty("user.dir"));
            InputStream in = new FileInputStream("src/main/java/Exercise/io/test.txt");
            InputStream bin = new BufferedInputStream(in);
            byte[] data = new byte[25];
            // TODO: 读取字节流的时候如何截断
            while (bin.read(data) != -1) {
                System.out.println(new String(data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

