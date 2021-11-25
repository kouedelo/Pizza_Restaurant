package model;

public class PaymentMethod {
    private String itemId;
    private String orderId;
    private String date;

    public PaymentMethod() {
    }

    public PaymentMethod(String itemId, String orderId, String date) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "itemId='" + itemId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
