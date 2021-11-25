package model;

public class OrderItem {
    private String itemId;

    public OrderItem() {
    }

    public OrderItem(String itemId) {
        this.itemId = itemId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId='" + itemId + '\'' +
                '}';
    }
}
