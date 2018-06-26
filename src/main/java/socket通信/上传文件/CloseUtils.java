package socket通信.上传文件;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtils {

    public static void close(Closeable c){
        if (c!=null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
