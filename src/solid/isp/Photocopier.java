package solid.isp;

public class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document document) {
        System.out.println("Print a document");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Scan a document");
    }
}
