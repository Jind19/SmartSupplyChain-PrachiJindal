package items;

public class Perishable extends Product{
    private int expirationDay;

    public int getExpirationDay() {
        return expirationDay;
    }

    public Perishable(int id, String name, int expirationDay) {
        super(id, name);
        this.expirationDay = expirationDay;
    }

    @Override
    public String getType() {
        return "Perishable";
    }

    public boolean isExpired(int today){
        return (expirationDay < today);
    }

    @Override
    public String toString() {
        return "Perishable[ID=" + id + ", Name=" + name + ", ExpirationDay=" + expirationDay + "]";
    }
}
