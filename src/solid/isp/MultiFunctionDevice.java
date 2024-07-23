package solid.isp;

interface MultiFunctionDevice extends Printer, Scanner, Fax {
}


class MultiFunctionMachine implements MultiFunctionDevice {
    private Printer printer;
    private Scanner scanner;
    private Fax faxSender;

    public MultiFunctionMachine(Printer printer, Scanner scanner, Fax faxSender) {
        this.printer = printer;
        this.scanner = scanner;
        this.faxSender = faxSender;

    }

    @Override
    public void print(Document document) {
        printer.print(document);
    }

    @Override
    public void scan(Document document) {
        scanner.scan(document);
    }

    @Override
    public void fax(Document document) {
        faxSender.fax(document);
    }
}


class Main {
    public static void main(String[] args) {
        Document doc = new Document();

        Printer printer = new BasePrinter();
        printer.print(doc);

        Scanner scanner = new Photocopier();
        scanner.scan(doc);

        FaxSender faxSender = new FaxSender();
        faxSender.fax(doc);

        // ----------------------------

        MultiFunctionDevice mfd = new MultiFunctionMachine(
                new BasePrinter(),
                new Photocopier(),
                new FaxSender()
        );
        mfd.print(doc);
        mfd.scan(doc);
        mfd.fax(doc);
    }
}