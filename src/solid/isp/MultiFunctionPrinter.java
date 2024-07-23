package solid.isp;

public class MultiFunctionPrinter implements Machine {
    @Override
    public void print(Document document) {
        System.out.println("Print");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Scan");

    }

    @Override
    public void fax(Document document) {
        System.out.println("Fax");

    }

}

class OldFashionedPrinter implements Machine {
    @Override
    public void print(Document document) {
        System.out.println("Print");
    }

    @Override
    public void scan(Document document) {
        System.out.println("Can't implement Scan with old fashioned printers.");

    }

    @Override
    public void fax(Document document) {
        System.out.println("Can't implement Fax with old fashioned printers.");
    }
}