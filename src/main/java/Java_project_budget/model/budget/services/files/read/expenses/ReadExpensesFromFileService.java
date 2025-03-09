package Java_project_budget.model.budget.services.files.read.expenses;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVReadTransformer;
import Java_project_budget.model.budget.utils.DisplayExpensesRecords;
import Java_project_budget.model.budget.utils.PrintMessages;
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
            if (!doesExpensesFileExists()) {
                PrintMessages.printMessageWithNewLine("\nDuomenų failas neegzistuoja.");
            } else {
                final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

                if (inputFromCSV.isEmpty()) {
                    PrintMessages.printMessageWithNewLine("\nNerasta jokių biudžeto išlaidų įrašų.");
                } else {
                    for (String string : inputFromCSV) {
                        readFromCSV(budgetExpensesRecordsList, string);
                    }
                    DisplayExpensesRecords.printExpensesRecords(budgetExpensesRecordsList);
                }
            }
        } catch (IOException exception) {
            PrintMessages.printMessageWithNewLine
                    ("\nĮvyko klaida, bandant gauti biudžeto išlaidų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }

    private void readFromCSV(List<BudgetRecord> budgetExpensesRecordsList, String string) {
        final String[] budgetRecordStrings = string.split(",");
        if (budgetRecordStrings.length != 7) {
            budgetExpensesRecordsList.add(expensesCSVReadTransformer.transformFromCSV(budgetRecordStrings));
        }
    }

    public boolean doesExpensesFileExists() {
        return Files.exists(FILE_PATH);
    }
}
