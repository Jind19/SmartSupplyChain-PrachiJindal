package main;

import exception.EmptyStorageException;
import exception.ExpiredProductException;
import exception.InvalidInputException;
import inventory.StorageUnit;
import items.Document;
import items.Electronic;
import items.Perishable;
import items.Product;

public class SmartSupplyChainApp {
    public static void main(String[] args) throws InvalidInputException, EmptyStorageException {


        Product doc = new Document(1, "Passport", "Id");
        Product phone = new Electronic(2, "iPhone 16", "Smartphone");
        Perishable milk = new Perishable(3, "Milk", 100);
        int today = 105;


        System.out.println(doc);
        System.out.println(phone);
        System.out.println(milk);

        System.out.println("[INFO] Trying to store milk...");
        try {
            milk.process(today);
        } catch(ExpiredProductException e){
            System.out.println("Error: " +e.getMessage());
        }


        StorageUnit<Product> singleStorage = new StorageUnit<>();
        singleStorage.addItem(doc);
        System.out.println("Single Storage: " + singleStorage.getItem());



    }
}
