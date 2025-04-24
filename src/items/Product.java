package items;

public abstract class Product {
    protected int id;
    protected String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //Abstract method doesn't have body
    public abstract String getType();

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
