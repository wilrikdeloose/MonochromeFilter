import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BitmapReaderTest {

    @Test
    public void readExistingBitmap() {
        for (File file: InputFiles.getAllBitmaps()) {
            try {
                final Bitmap bitmap = new BitmapReader().read(file.getAbsolutePath());
                Assert.assertNotNull(bitmap);
            } catch (IOException e) {
                Assert.fail();
            }
        }
    }

    @Test(expected = IOException.class)
    public void readNonExistingBitmap() throws IOException {
        new BitmapReader().read("./images/wrong_filename.bmp");
    }
}