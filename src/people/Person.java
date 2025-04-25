package people;

import exception.InvalidInputException;

public abstract class Person {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();

    public Person(int id, String name) throws InvalidInputException {
        if (id <= 0) {
            throw new InvalidInputException("ID must be a positive number.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidInputException("Name cannot be null or blank.");
        }
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return getRole() + "(" + "id='" + id + "', name='" + name + "')";
    }


}
