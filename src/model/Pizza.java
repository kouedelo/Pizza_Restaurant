package model;

public class Pizza extends OrderItem {
    private String size;
    private String crust;
    private int quantity;
    private double price;

    public Pizza() {
    }

    public Pizza(String size, String crust, int quantity, double price) {
        this.size = size;
        this.crust = crust;
        this.quantity = quantity;
        this.price = price;
    }

    public Pizza(String itemId, String size, String crust, int quantity, double price) {
        super(itemId);
        this.size = size;
        this.crust = crust;
        this.quantity = quantity;
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", crust='" + crust + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
