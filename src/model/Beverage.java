package model;

public class Beverage extends OrderItem{
    private String name;

    public Beverage() {
    }

    public Beverage(String name) {
        this.name = name;
    }

    public Beverage(String itemId, int quantity, double price, String name) {
        super(itemId, quantity, price);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                '}';
    }
}
