import java.io.File;

public class InputFiles {
    public static File[] getAllBitmaps() {
        File folder = new File("./images");
        File[] files = folder.listFiles(filename -> filename.getName().contains("bmp"));
        return files;
    }
}
