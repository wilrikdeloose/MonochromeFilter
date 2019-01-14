public class Bitmap {
    public final int STATIC_HEADER_SIZE;

    private final int MULTIPLE_OF_FOUR_BYTES = 4;
    private byte[] data;
    private int width, height;

    public int getPixelCount() { return width * height; }

    public byte[] getData() { return this.data.clone(); }

    private int getByte(int index) { return data[index] & 0xFF; }

    private int getWord(int index) {
        return (int)
                (getByte(index) +
                (getByte(index + 1) * Math.pow(256, 1)) +
                (getByte(index + 2) * Math.pow(256, 2)) +
                (getByte(index + 3) * Math.pow(256, 3)));
    }

    public Bitmap(byte[] data) {
        this.data = new byte[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);

        STATIC_HEADER_SIZE = getByte(10);
        this.width = getWord(18);
        this.height = getWord(22);
    }

    private int pixelIndexToDataIndex(int pixelIndex) {
        //int rowIndex = (int) Math.floor(pixelIndex / width);
        //double bytesPerRow = ((double)width * (double)Pixel.NUMBER_OF_COLORS) / (double)MULTIPLE_OF_FOUR_BYTES;
        //int paddingPerRow = (int) ((Math.ceil(bytesPerRow) - bytesPerRow) / 0.25);

        return STATIC_HEADER_SIZE + (pixelIndex * Pixel.NUMBER_OF_COLORS);// + (rowIndex * paddingPerRow);
    }

    public Pixel getPixel(int pixelIndex) {
        return new Pixel(this.data, pixelIndexToDataIndex(pixelIndex));
    }

    public void setPixel(Pixel pixel, int pixelIndex) {
        final int R_INDEX = pixelIndexToDataIndex(pixelIndex) + Pixel.INDEX_OFFSET_R;
        final int G_INDEX = pixelIndexToDataIndex(pixelIndex) + Pixel.INDEX_OFFSET_G;
        final int B_INDEX = pixelIndexToDataIndex(pixelIndex) + Pixel.INDEX_OFFSET_B;

        this.data[R_INDEX] = (byte)pixel.getR();
        this.data[G_INDEX] = (byte)pixel.getG();
        this.data[B_INDEX] = (byte)pixel.getB();
    }

    @Override
    public boolean equals(Object obj) {
        Bitmap otherBitmap = (Bitmap) obj;
        byte[] otherData = otherBitmap.getData();

        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != otherData[i]) {
                return false;
            }
        }

        return true;
    }
}
