package model;

public class PizzaTopping {
    private String pizzaId;
    private String toppingName;
    private double price;

    public PizzaTopping() {
    }

    public PizzaTopping(String pizzaId, String toppingName, double price) {
        this.pizzaId = pizzaId;
        this.toppingName = toppingName;
        this.price = price;
    }

    public String getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(String pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PizzaTopping{" +
                "pizzaId='" + pizzaId + '\'' +
                ", toppingName='" + toppingName + '\'' +
                ", price=" + price +
                '}';
    }
}
