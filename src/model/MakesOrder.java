package model;

public class MakesOrder {
    private String phoneNumber;
    private String orderId;

    public MakesOrder() {
    }

    public MakesOrder(String phoneNumber, String orderId) {
        this.phoneNumber = phoneNumber;
        this.orderId = orderId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "MakesOrder{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
