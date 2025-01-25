package project;

public class Transaction {
    public String sender;
    public String receiver;
    public float amount;

    public Transaction(String from, String to, float amount){
        this.sender = from;
        this.receiver=to;
        this.amount=amount;
    }

    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", amount=" + amount +
                '}';
    }
}
