import java.time.format.DateTimeFormatter;

public class Transaction {
    private DateTimeFormatter date;
    private String id;
    private Bank bank;
    private String description;
    private long transactionAmount;
    private String receiveAccount;

    public Transaction(DateTimeFormatter date, String id, Bank bank, String description, long transactionAmount, String receiveAccount) {
        this.date = date;
        this.id = id;
        this.bank = bank;
        this.description = description;
        this.transactionAmount = transactionAmount;
        this.receiveAccount = receiveAccount;
    }

    public DateTimeFormatter getDate() {
        return date;
    }

    public void setDate(DateTimeFormatter date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getReceiveAccount() {
        return receiveAccount;
    }

    public void setReceiveAccount(String receiveAccount) {
        this.receiveAccount = receiveAccount;
    }

    @Override
    public String toString() {
        return date +" - "+id+" - "+description+" - "+receiveAccount+" - "+transactionAmount;
    }
}
