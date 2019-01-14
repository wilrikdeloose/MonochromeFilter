import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class BitmapReader {
    public Bitmap read(String filename) throws IOException {
        final File file = new File(filename);
        final BufferedImage image = ImageIO.read(file);
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageIO.write(image, "bmp", outputStream);
        outputStream.flush();

        final byte[] imageData = outputStream.toByteArray();
        outputStream.close();

        return new Bitmap(imageData);
    }
}
