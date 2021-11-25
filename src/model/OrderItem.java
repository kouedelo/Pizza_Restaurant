package model;

public class OrderItem {
    private String orderId;

    public OrderItem() {
    }

    public OrderItem(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
