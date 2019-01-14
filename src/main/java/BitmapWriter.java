import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapWriter {
    public void write(Bitmap bitmap, String filename) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        outputStream.write(bitmap.getData());
    }
}
