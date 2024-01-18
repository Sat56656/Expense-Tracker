import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    private static final Map<String, Double> expenses = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nExpense Tracker Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Exiting Expense Tracker. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter the expense amount: ");
        double amount = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the expense category: ");
        String category = scanner.nextLine().toLowerCase();

        if (expenses.containsKey(category)) {
            expenses.put(category, expenses.get(category) + amount);
        } else {
            expenses.put(category, amount);
        }

        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded yet.");
        } else {
            System.out.println("\nExpense Summary:");
            for (Map.Entry<String, Double> entry : expenses.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }
            System.out.println("Total Expenses: $" + calculateTotalExpenses());
        }
    }

    private static double calculateTotalExpenses() {
        double total = 0;
        for (double amount : expenses.values()) {
            total += amount;
        }
        return total;
    }
}
