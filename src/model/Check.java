package model;

public class Check {
    private String paymentId;
    private String checkIssuer;
    private String reference;
    private String bank;

    public Check() {
    }

    public Check(String paymentId, String checkIssuer, String reference, String bank) {
        this.paymentId = paymentId;
        this.checkIssuer = checkIssuer;
        this.reference = reference;
        this.bank = bank;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getCheckIssuer() {
        return checkIssuer;
    }

    public void setCheckIssuer(String checkIssuer) {
        this.checkIssuer = checkIssuer;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    @Override
    public String toString() {
        return "Check{" +
                "paymentId='" + paymentId + '\'' +
                ", checkIssuer='" + checkIssuer + '\'' +
                ", reference='" + reference + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}
