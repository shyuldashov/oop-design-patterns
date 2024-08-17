package behavioral.memento;


public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public BankAccountSnapshot deposit(int amount) {
        balance += amount;
        return new BankAccountSnapshot(balance);
    }

    public void restore(BankAccountSnapshot bankAccountSnapshot) {
        balance = bankAccountSnapshot.getBalance();
    }

    @Override
    public String toString() {
        return String.format("BankAccount(balance=%d)", balance);
    }
}
