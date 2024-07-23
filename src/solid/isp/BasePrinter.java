package solid.isp;

public class BasePrinter implements Printer {
    public void print(Document document) {
        System.out.println("Print as document");
    }
}
