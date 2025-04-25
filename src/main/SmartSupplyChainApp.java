package main;

import exception.EmptyStorageException;
import exception.ExpiredProductException;
import exception.InvalidInputException;
import inventory.MultiStorageUnit;
import inventory.StorageUnit;
import items.Document;
import items.Electronic;
import items.Perishable;
import items.Product;

import java.util.ArrayList;
import java.util.List;

public class SmartSupplyChainApp {

    public static void main(String[] args) throws InvalidInputException, EmptyStorageException {


        Product doc = new Document(1, "Passport", "Id");
        Product phone = new Electronic(2, "iPhone 16", "Smartphone");
        Perishable milk = new Perishable(3, "Milk", 100);
        int today = 105;

        System.out.println("[INFO] Trying to store milk...");
        try {
            milk.process(today);
        } catch(ExpiredProductException e){
            System.out.println("Error: " +e.getMessage());
        }

        StorageUnit<Product> singleStorage = new StorageUnit<>();
        singleStorage.addItem(doc);
        singleStorage.addItem(phone);
        singleStorage.getItem();

        MultiStorageUnit<Product> multiStorageUnit = new MultiStorageUnit<>();
        List<Product> listOfItems= new ArrayList<>();
        listOfItems.add(doc);
        listOfItems.add(phone);
        listOfItems.add(milk);

        multiStorageUnit.addItems(listOfItems);
        multiStorageUnit.printAll();





    }
}
