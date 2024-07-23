package solid.isp;

public class FaxSender implements Fax{
    @Override
    public void fax(Document document) {
        System.out.println("Fax a document");
    }
}
