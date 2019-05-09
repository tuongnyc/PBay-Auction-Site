public class User {
    private String name;
    private double accountBalance;

    public User(String nm) {
        name = nm;
        accountBalance = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double updateBalance(double bal) {
        accountBalance = bal;

        return accountBalance;
    }

    public String toString() {
        return name + "'s balance is " + accountBalance;
    }
}
