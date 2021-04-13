package bank;

public class Account {

    private String name;
    private int balance;

    public Account(String name) {
        this.name = name;
        balance = 0;
    }

    //returns the current balance
    public int getShekels() {
        return balance;
    }

    //returns the name of the account's owner
    public String getName() {
        return name;
    }

    // adds the entered amount to the account
    public void add(int amount) {
        balance += amount;
    }

    // returns a phrase describing the owner's current balance
    public String toString() {
        return name + " has " + balance + " shekels";
    }
}
