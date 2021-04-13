package bank;

public class ProAccount extends Account {

    private int balance;
    private int[] balanceHistory = new int[100];
    private int historyLength;

    public ProAccount(String name) {
        super(name);
    }

    // transfers a chosen sum from one account to another
    public static void transfer(ProAccount from, ProAccount to, int amount) {
        to.add(amount);
        from.add(-amount);
    }
    
    // adds the entered amount to the account and updates the history array
    @Override
    public void add(int amount) {
        if (historyLength == 0) {
            balanceHistory[0] = amount;
        } else {
            balanceHistory[historyLength] = balanceHistory[historyLength - 1] + amount;
        }
        balance = balanceHistory[historyLength];
        historyLength++;
    }
    
    // returns a phrase describing the owner's current balance and his balance history
    @Override
    public String toString() {
        String str = getName() + " has " + balance + " shekels [";
        for (int i = 0; i < historyLength - 1; i++) {
            str = str + balanceHistory[i] + ",";
        }
        return str = str + balance + "]";
    }
}
