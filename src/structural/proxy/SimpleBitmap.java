package structural.proxy;


public class SimpleBitmap implements Bitmap {
    public String filename;

    public SimpleBitmap(String filename) {
        this.filename = filename;
        System.out.println("Loading image from " + filename);
    }

    public void draw() {
        System.out.println("Drawing image " + filename);
    }
}


class MainTwo {
    static void printInfo(Bitmap bitmap) {
        System.out.println("About to draw image");
        bitmap.draw();
        System.out.println("Down drawing image");
    }

    public static void main(String[] args) {

        // With SimpleBitmap, even if you don't use printInfo,
        // the constructor will still start loading the image
        SimpleBitmap simpleBitmap = new SimpleBitmap("nature.png");
        printInfo(simpleBitmap);

        // This behavior does not occur when using LazyBitmap,
        // since the image is loaded lazily
        LazyBitmap lazyBitmap = new LazyBitmap("world.png");
        printInfo(lazyBitmap);


    }
}