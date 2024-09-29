import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    if (account.withdraw(scanner.nextDouble()))
                        System.out.println("Withdrawal successful.");
                    else
                        System.out.println("Insufficient balance.");
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    if (account.deposit(scanner.nextDouble()))
                        System.out.println("Deposit successful.");
                    else
                        System.out.println("Invalid amount.");
                    break;
                case 3:
                    System.out.printf("Current balance: $%.2f%n", account.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        new ATM(new BankAccount(100)).run(); // Create ATM with $100 balance and run it
    }
}
