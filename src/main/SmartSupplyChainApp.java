package main;

import items.Document;
import items.Electronic;
import items.Perishable;
import items.Product;

public class SmartSupplyChainApp {
    public static void main(String[] args) {


        Product doc = new Document(1, "Passport", "Id");
        Product phone = new Electronic(2, "iPhone 16", "Smartphone");
        Product milk = new Perishable(3, "Milk", 100);


        System.out.println(doc);
        System.out.println(phone);
        System.out.println(milk);

    }
}
