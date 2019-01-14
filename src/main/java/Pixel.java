public class Pixel {
    public static final int NUMBER_OF_COLORS = 3;
    public static final int INDEX_OFFSET_R = 2;
    public static final int INDEX_OFFSET_G = 1;
    public static final int INDEX_OFFSET_B = 0;

    private int R;
    private int G;
    private int B;

    public int getR() { return this.R; }
    public int getG() { return this.G; }
    public int getB() { return this.B; }

    public Pixel(int greyscale) {
        this.R = greyscale;
        this.G = greyscale;
        this.B = greyscale;
    }

    public Pixel(byte[] imageData, int index) {
        this.R = imageData[index + INDEX_OFFSET_R] & 0xFF;
        this.G = imageData[index + INDEX_OFFSET_G] & 0xFF;
        this.B = imageData[index + INDEX_OFFSET_B] & 0xFF;
    }

    public int getAverageColor() { return (R + G + B) / NUMBER_OF_COLORS; }
}