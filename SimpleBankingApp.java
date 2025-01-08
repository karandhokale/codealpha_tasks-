import java.util.Scanner;

public class SimpleBankingApp {

    // Declare a variable to store the balance
    static double balance = 0.0;

    // Method to handle deposits
    public static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("Deposited: $" + depositAmount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to handle withdrawals
    public static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("Withdrawn: $" + withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the balance
    public static void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Main method to drive the application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String continueChoice;

        do {
            System.out.println("\n--- Banking Application ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you for using our banking service!");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    continue;
            }

            // Ask the user if they want to continue after completing an action
            System.out.print("\nDo you want to perform another action? (yes/no): ");
            continueChoice = scanner.next();

            // If the user chooses "no", the loop will end
            if (continueChoice.equalsIgnoreCase("no")) {
                System.out.println("Exiting the application. Thank you for using our banking service!");
                break;
            }

        } while (true);

        scanner.close();
    }
}
