package items;

public class Document extends Product{
    private String documentType;

    public Document(int id, String name, String documentType) {
        super(id, name);
        this.documentType = documentType;
    }

    @Override
    public String getType() {
        return "Document";
    }

    @Override
    public String toString() {
        return "Document[ID=" + id + ", Name=" + name + ", DocumentType=" + documentType + "]";
    }
}
