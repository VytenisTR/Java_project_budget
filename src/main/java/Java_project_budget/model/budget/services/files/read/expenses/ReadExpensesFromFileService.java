package Java_project_budget.model.budget.services.files.read.expenses;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVReadTransformer;
import Java_project_budget.model.budget.services.files.utils.FileReadUtilities;
import Java_project_budget.model.budget.utils.DisplayExpensesRecords;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ReadExpensesFromFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetExpensesRecords.csv");
    private final ExpensesCSVReadTransformer expensesCSVReadTransformer = new ExpensesCSVReadTransformer();

    public void readExpensesFromCSV() {
        List<BudgetRecord> budgetExpensesRecordsList = new ArrayList<>();

        try {
            final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

            if (inputFromCSV.isEmpty()) {
                System.out.println("\nNerasta jokių įrašų.");
            } else if (!FileReadUtilities.checkIfExpensesRecordExists(inputFromCSV)) {
                System.out.println("\nNerasta jokių biudžeto išlaidų įrašų.");
            } else {
                for (String string : inputFromCSV) {
                    final String[] budgetRecordStrings = string.split(",");
                    if (budgetRecordStrings.length != 6) {
                        budgetExpensesRecordsList.add(expensesCSVReadTransformer.transformFromCSV(budgetRecordStrings));
                    }
                }
                DisplayExpensesRecords.printExpensesRecords(budgetExpensesRecordsList);
            }
        } catch (IOException exception) {
            System.out.println("\nĮvyko klaida, bandant gauti biudžeto išlaidų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }
}
