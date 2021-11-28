package model;

public class Sides extends OrderItem{
    private String name;

    public Sides() {
    }

    public Sides(String name) {
        this.name = name;
    }

    public Sides(String itemId, int quantity, double price, String name) {
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
        return "Sides{" +
                "name='" + name + '\'' +
                '}';
    }
}
