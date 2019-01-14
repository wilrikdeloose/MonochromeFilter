import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BitmapWriterTest {

    @Test
    public void writeReadBitmapToFile() {
        for (File file: InputFiles.getAllBitmaps()) {
            String inputFilename = file.getAbsolutePath();
            String outputFilename = inputFilename.substring(0, inputFilename.lastIndexOf("\\")) + "\\output.bmp";

            try {
                final Bitmap bitmap = new BitmapReader().read(inputFilename);
                new BitmapWriter().write(bitmap, outputFilename);

                final File outputFile = new File(outputFilename);
                Assert.assertTrue(outputFile.exists() && outputFile.isFile());
                outputFile.delete();
            } catch (IOException e) {
                Assert.fail();
                return;
            }
        }
    }
}