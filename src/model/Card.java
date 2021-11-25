package model;

public class Card {
    private String paymentId;
    private String cvc;
    private String cardNumber;
    private String zipCode;
    private String nameOnCard;
    private String date;

    public Card() {
    }

    public Card(String paymentId, String cvc, String cardNumber, String zipCode, String nameOnCard, String date) {
        this.paymentId = paymentId;
        this.cvc = cvc;
        this.cardNumber = cardNumber;
        this.zipCode = zipCode;
        this.nameOnCard = nameOnCard;
        this.date = date;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Card{" +
                "paymentId='" + paymentId + '\'' +
                ", cvc='" + cvc + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", nameOnCard='" + nameOnCard + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
