package people;

import exception.ExpiredProductException;
import exception.InvalidInputException;
import items.Perishable;
import items.Product;
import inventory.Package;

import java.util.List;

public class Customer extends Person{


    public Customer(int id, String name) throws InvalidInputException {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "Customer";
    }

    public void receivePackage(Package<?> customerPackage, int today) throws InvalidInputException, ExpiredProductException {
        List<?> items = customerPackage.getItems();
        for (Object obj : items) {
            if (obj instanceof Perishable) {
                Perishable perishable = (Perishable) obj;
                if (perishable.isExpired(today)) {
                    throw new ExpiredProductException("Package contains expired product: " + perishable.getName());
                }
            }
        }
        System.out.println("Customer " + getName() + " received package: ");
    }

}
