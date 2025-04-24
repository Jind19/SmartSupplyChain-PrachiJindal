package items;

import exception.ExpiredProductException;

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

    // Process the product and check if it's expired
    public void process(int today) throws ExpiredProductException {
        if(isExpired(today)){
            throw new ExpiredProductException("Product " + name + " is expired and cannot be processed.");
        } else {
            System.out.println("Processing perishable product: " + name);
        }
    }

    @Override
    public String toString() {
        return "Perishable[ID=" + id + ", Name=" + name + ", ExpirationDay=" + expirationDay + "]";
    }
}
