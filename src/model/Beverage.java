package model;

public class Beverage extends OrderItem{
    private String name;
    private String size;

    public Beverage() {
    }

    public Beverage(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public Beverage(String itemId, int quantity, double price, String name, String size) {
        super(itemId, quantity, price);
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Beverage{" +
                "name='" + name + '\'' +
                '}';
    }
}
