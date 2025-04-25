package main;

import exception.EmptyStorageException;
import exception.ExpiredProductException;
import exception.InvalidInputException;
import inventory.MultiStorageUnit;
import inventory.Package;
import inventory.StorageUnit;
import items.Document;
import items.Electronic;
import items.Perishable;
import items.Product;
import people.Customer;
import people.Person;
import people.Supplier;

import java.util.ArrayList;
import java.util.List;

public class SmartSupplyChainApp {

    public static void main(String[] args) throws InvalidInputException, EmptyStorageException, ExpiredProductException {


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

        Supplier supplier = new Supplier(1, "Fresh Farms");
        Customer customer = new Customer(2, "Retail Mart");

        Package<Product> package1 = new Package<>();
        package1.addItem(milk);
        package1.addItem(doc);

        // Supplier adds the package to their inventory
        supplier.addPackage(package1);

        // Try to have the customer receive the package
        try {
            customer.receivePackage(package1, 111); // Today is day 111
        } catch (ExpiredProductException e) {
            // Handle the exception if a product is expired
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidInputException e) {
            // Handle invalid input exception (e.g., null or empty fields)
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other general exceptions
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }
}
