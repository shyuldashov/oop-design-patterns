package behavioral.memento;


public class BankAccountSnapshot {
    private int balance;

    public BankAccountSnapshot(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}


class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(100);
        BankAccountSnapshot bankAccountSnapshot1 = bankAccount.deposit(50);
        BankAccountSnapshot bankAccountSnapshot2 = bankAccount.deposit(25);
        System.out.println(bankAccount);

        // restore to bankAccountSnapshot1
        bankAccount.restore(bankAccountSnapshot1);
        System.out.println(bankAccount);

        // restore to bankAccountSnapshot2
        bankAccount.restore(bankAccountSnapshot2);
        System.out.println(bankAccount);

        /*
        BankAccount(balance=175)
        BankAccount(balance=150)
        BankAccount(balance=175)
         */
    }
}
