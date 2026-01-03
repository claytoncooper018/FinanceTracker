import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    private List<Transaction> transactions;
    private final String DATA_FILE = "data/transactions.csv";

    public FinanceManager() {
        transactions = new ArrayList<>();
        loadTransactions();
    }

    private void loadTransactions() {
        File file = new File(DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts.length != 4) continue; // skip malformed lines
                LocalDate date = LocalDate.parse(parts[0]);
                String desc = parts[1];
                String category = parts[2];
                double amount = Double.parseDouble(parts[3]);
                transactions.add(new Transaction(date, desc, category, amount));
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        saveTransaction(t);
    }

    private void saveTransaction(Transaction t) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            bw.write(t.getDate() + "," + t.getDescription() + "," + t.getCategory() + "," + t.getAmount());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error saving transaction: " + e.getMessage());
        }
    }

    public void printAllTransactions() {
        System.out.println("\nAll Transactions:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public void printSummary() {
        double income = 0;
        double expenses = 0;
        for (Transaction t : transactions) {
            if(t.getAmount() > 0) income += t.getAmount();
            else expenses += t.getAmount();
        }
        System.out.println("\nSummary:");
        System.out.println("Total Income: $" + income);
        System.out.println("Total Expenses: $" + expenses);
        System.out.println("Balance: $" + (income + expenses));
    }
}
