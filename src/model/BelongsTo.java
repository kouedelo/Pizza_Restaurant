package model;

public class BelongsTo {
    private String itemId;
    private String orderId;
    private double cost;

    public BelongsTo() {
    }

    public BelongsTo(String itemId, String orderId, double cost) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.cost = cost;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BelongsTo{" +
                "itemId='" + itemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", cost=" + cost +
                '}';
    }
}
