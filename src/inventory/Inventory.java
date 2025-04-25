package inventory;

import exception.ExpiredProductException;
import exception.InvalidInputException;
import items.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory<T extends Product> {

    private Map<String, Package<T>> packageMap = new HashMap<>();

    public void addNewPackage(String id, Package<T> pkg) throws InvalidInputException {
        if (id == null || pkg == null) {
            throw new InvalidInputException("ID or Package cannot be null.");
        }
        packageMap.put(id, pkg);
    }

    public Package<T> retrievePackageByID(int Id) throws InvalidInputException {
        if (!packageMap.containsKey(Id)) {
            throw new InvalidInputException("Package ID not found.");
        }
        return packageMap.get(Id);
    }

    public void printProductList(List<? extends Product> items) {
        for (Product p : items) {
            System.out.println(" - " + p);
        }
    }

    public void validateAllPackages(int today) throws ExpiredProductException {
        for (Package<T> pkg : packageMap.values()) {
            pkg.validateItems(today);
        }
    }
}
