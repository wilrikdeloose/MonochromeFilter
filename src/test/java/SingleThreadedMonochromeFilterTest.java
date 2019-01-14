import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class SingleThreadedMonochromeFilterTest {

    @Test
    public void applySingleThreadedMonochromeFilter() {
        for (File file: InputFiles.getAllBitmaps()) {
            try {
                String inputFilename = file.getAbsolutePath();
                String outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf("\\")) + "\\output.bmp";

                final Bitmap bitmap = new BitmapReader().read(inputFilename);
                new SingleThreadedMonochromeFilter().apply(bitmap);
                new BitmapWriter().write(bitmap, outputFilename);

                final File outputFile = new File(outputFilename);
                Assert.assertTrue(outputFile.exists());
                outputFile.delete();
            } catch (IOException e) {
                Assert.fail();
            }
        }
    }
}