package inventory;

import exception.EmptyStorageException;
import exception.InvalidInputException;

public class StorageUnit<T> {
    private T item;

    // Add item to storage
    public void addItem(T item) throws InvalidInputException {
        if(item == null){
            throw new InvalidInputException("Cannot add null item to storage.");
        }
        this.item = item;
        System.out.println("Item stored successfully: " + item);
    }

    // Retrieve item
    public T getItem() throws EmptyStorageException {
        if (item == null) { // 🧠 This is how we know it's empty!
            throw new EmptyStorageException("Storage is empty! Cannot retrieve item.");
        }
        return item;
    }

}
