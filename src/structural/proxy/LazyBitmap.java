package structural.proxy;


public class LazyBitmap implements Bitmap {
    public String filename;
    protected Bitmap bitmap;

    public LazyBitmap(String filename) {
        this.filename = filename;
    }

    @Override
    public void draw() {
        if (bitmap == null) {
            this.bitmap = new SimpleBitmap(filename);
        }
        this.bitmap.draw();
    }
}
