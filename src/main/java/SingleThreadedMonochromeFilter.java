public class SingleThreadedMonochromeFilter implements IFilter {
    @Override
    public void apply(Bitmap bitmap) {
        for (int i = 0; i < bitmap.getPixelCount(); i++) {
            Pixel oldPixel = bitmap.getPixel(i);
            int averageColor = oldPixel.getAverageColor();
            Pixel newPixel = new Pixel(averageColor);
            bitmap.setPixel(newPixel, i);
        }
    }
}
