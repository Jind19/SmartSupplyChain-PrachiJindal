package inventory;

import exception.ExpiredProductException;
import exception.InvalidInputException;
import items.Perishable;
import items.Product;

import java.util.ArrayList;
import java.util.List;

public class Package<T extends Product>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item) throws InvalidInputException {
        if (item == null) {
            throw new InvalidInputException("Item cannot be null.");
        }
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void validateItems(int today) throws ExpiredProductException {
        for (T item : items) {
            if (item instanceof Perishable) {
                Perishable p = (Perishable) item;
                if (p.isExpired(today)) {
                    throw new ExpiredProductException(item.getName() + " is expired.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Package: " + items.toString();
    }
}
