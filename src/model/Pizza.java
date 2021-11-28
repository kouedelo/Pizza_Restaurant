package model;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends OrderItem {
    private String size;
    private String crust;
    private List<PizzaTopping> toppings = new ArrayList<>();

    public Pizza() {
    }

    public Pizza(String size, String crust, List<PizzaTopping> toppings) {
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
    }

    public Pizza(String itemId, int quantity, double price, String size, String crust, List<PizzaTopping> toppings) {
        super(itemId, quantity, price);
        this.size = size;
        this.crust = crust;
        this.toppings = toppings;
    }

    public Pizza(String itemId, int quantity, double price, String size, String crust) {
        super(itemId, quantity, price);
        this.size = size;
        this.crust = crust;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public List<PizzaTopping> getToppings() {
        return toppings;
    }

    public void setToppings(List<PizzaTopping> toppings) {
        this.toppings = toppings;
    }

    public String getToppingsNames() {
        String names = "";
        for (PizzaTopping topping :
                this.toppings) {
            names += topping.getToppingName() + ", ";
        }
        return names;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", toppings=" + toppings +
                '}';
    }
}
