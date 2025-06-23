import java.util.*;

public class ATM {
    private double balance;
    private List<String> transactions;
    private final String correctPin = "1234";

    public ATM() {
        balance = 1000.0; // initial balance
        transactions = new ArrayList<>();
    }

    public boolean login(String pin) {
        return correctPin.equals(pin);
    }

    public void checkBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited ₹" + amount);
            System.out.println("✅ ₹" + amount + " deposited successfully.");
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew ₹" + amount);
            System.out.println("✅ ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    public void showTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("📭 No transactions yet.");
        } else {
            System.out.println("📜 Transaction History:");
            for (String t : transactions) {
                System.out.println(" - " + t);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.println("🏦 Welcome to the Java ATM");
        System.out.print("Enter PIN to access: ");
        String pin = scanner.nextLine();

        if (!atm.login(pin)) {
            System.out.println("❌ Incorrect PIN. Access Denied.");
            return;
        }

        while (true) {
            System.out.println("\n🔘 Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = scanner.nextDouble();
                    atm.deposit(depositAmt);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    atm.withdraw(withdrawAmt);
                    break;
                case 4:
                    atm.showTransactions();
                    break;
                case 5:
                    System.out.println("👋 Thank you for using Java ATM!");
                    return;
                default:
                    System.out.println("❌ Invalid option. Try again.");
            }
        }
    }
}