package Exercise.Logger;

import sun.rmi.runtime.Log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter writer;

    public Logger() throws IOException {
        File file = new File("/Users/dasouche/Desktop/log.txt");
        writer = new FileWriter(file, true);
    }

    public void log(String message) throws IOException {
        // 对于非单例对象，可以使用类锁互斥
        synchronized (Logger.class) {
            writer.write(message);
            writer.flush();
        }
    }

    public static void main(String[] args)  {
        try {
            Logger logger = new Logger();
            logger.log("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}