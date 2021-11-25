package model;

public class Cash {
    private String paymentId;
    private int numberOfBankNotes;
    private String typeOfBankNote;

    public Cash() {
    }

    public Cash(String paymentId, int numberOfBankNotes, String typeOfBankNote) {
        this.paymentId = paymentId;
        this.numberOfBankNotes = numberOfBankNotes;
        this.typeOfBankNote = typeOfBankNote;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public int getNumberOfBankNotes() {
        return numberOfBankNotes;
    }

    public void setNumberOfBankNotes(int numberOfBankNotes) {
        this.numberOfBankNotes = numberOfBankNotes;
    }

    public String getTypeOfBankNote() {
        return typeOfBankNote;
    }

    public void setTypeOfBankNote(String typeOfBankNote) {
        this.typeOfBankNote = typeOfBankNote;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "paymentId='" + paymentId + '\'' +
                ", numberOfBankNotes=" + numberOfBankNotes +
                ", typeOfBankNote='" + typeOfBankNote + '\'' +
                '}';
    }
}
