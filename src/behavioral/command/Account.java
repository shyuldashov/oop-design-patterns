package behavioral.command;


public class Account {
    public int balance;

    public Account() {
    }

    public void process(Command command) {
        switch (command.action) {
            case DEPOSIT -> {
                command.success = true;
                balance += command.amount;
            }
            case WITHDRAW -> {
                if (balance - command.amount < 0) {
                    command.success = false;
                } else {
                    command.success = true;
                    balance -= command.amount;
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Account(balance=%d)", balance);
    }
}


class Main {
    public static void main(String[] args) {
        Account account = new Account();
        Command command = new Command(Command.Action.DEPOSIT, 100);
        account.process(command);
        System.out.println(account);
        System.out.printf(
                "Operation was successfully completed: %s%n",
                command.success
        );

        // --------------------

        command = new Command(Command.Action.WITHDRAW, 50);
        account.process(command);
        System.out.println(account);
        System.out.printf(
                "Operation was successfully completed: %s%n",
                command.success
        );

        // --------------------

        command = new Command(Command.Action.WITHDRAW, 150);
        account.process(command);
        System.out.println(account);
        System.out.printf(
                "Operation was successfully completed: %s%n",
                command.success
        );

    }
}
