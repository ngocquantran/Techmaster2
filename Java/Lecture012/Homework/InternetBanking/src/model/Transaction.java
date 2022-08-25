package model;

import model.Bank;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private Date date;
    private int id;
    private Bank bank;
    private String description;
    private long transactionAmount;
    private String receiveAccount;

    public Transaction( int id,Date date, Bank bank, String description, long transactionAmount, String receiveAccount) {
        this.date = date;
        this.id = id;
        this.bank = bank;
        this.description = description;
        this.transactionAmount = transactionAmount;
        this.receiveAccount = receiveAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    DecimalFormat dcf=new DecimalFormat("###,###,###");

    @Override
    public String toString() {
        return id+" - "+new SimpleDateFormat("dd/MM/yyyy").format(date) +" - "+description+" - "+receiveAccount+" - "+dcf.format(transactionAmount);
    }
}
