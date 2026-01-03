import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Personal Finance Tracker ===");

        while (true) {
            System.out.println("\n1. Add Transaction\n2. View Transactions\n3. View Summary\n4. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter amount (positive for income, negative for expense): ");
                    double amt = sc.nextDouble();
                    manager.addTransaction(new Transaction(LocalDate.now(), desc, cat, amt));
                    break;
                case 2:
                    manager.printAllTransactions();
                    break;
                case 3:
                    manager.printSummary();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
