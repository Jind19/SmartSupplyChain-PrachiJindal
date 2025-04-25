package people;

import exception.InvalidInputException;
import items.Product;
import inventory.Package;

import java.util.ArrayList;
import java.util.List;

public class Supplier extends Person{
    private List<Package<? extends Product>> suppliedPackages;

    public Supplier(int id, String name) throws InvalidInputException {
        super(id, name);
        this.suppliedPackages = new ArrayList<>();
    }

    @Override
    public String getRole() {
        return "Supplier";
    }

    public void addPackage(Package<? extends Product> pkg) throws InvalidInputException {
        if (pkg == null) {
            throw new InvalidInputException("Cannot add null package.");
        }
        suppliedPackages.add(pkg);
    }

    public List<Package<? extends Product>> getPackages() {
        return suppliedPackages;
    }
}
