package solid.isp;


// This is a bad interface, it has many different methods
public interface Machine {
    void print(Document document);

    void scan(Document document);

    void fax(Document document);
}
