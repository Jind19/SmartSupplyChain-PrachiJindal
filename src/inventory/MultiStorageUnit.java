package inventory;

import exception.EmptyStorageException;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class MultiStorageUnit<T>{

    private List<T> items = new ArrayList<>();

    //Add single item t storage
    public void addItem(T newItem) throws InvalidInputException {
        if (newItem == null) {
            throw new InvalidInputException("Cannot add null item to storage.");
        }
        this.items.add(newItem);
    }

    // Add a list of items to storage
    public void addItems(List<T> newItems) throws InvalidInputException {
        if (newItems == null || newItems.contains(null)) {
            throw new InvalidInputException("Cannot add null items to storage.");
        }
        this.items.addAll(newItems);
    }

    // Retrieve all items from storage
    public List<T> getItems() throws EmptyStorageException {
        if (items.isEmpty()) {
            throw new EmptyStorageException("Storage is empty, cannot retrieve items.");
        }
        return new ArrayList<>(items);
    }

    public void printAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }

}
