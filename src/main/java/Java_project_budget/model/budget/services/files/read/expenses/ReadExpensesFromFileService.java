package Java_project_budget.model.budget.services.files.read.expenses;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVReadTransformer;
import Java_project_budget.model.budget.utils.BudgetListSizeResolver;
import Java_project_budget.model.budget.utils.DisplayExpensesRecords;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
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
        int expensesRecordsCount = 1;

        try {
            if (!doesExpensesFileExists()) {
                PrintMessages.printMessageWithNewLine("\nDuomenų failas neegzistuoja.");
            } else {
                final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

                if (inputFromCSV.isEmpty()) {
                    PrintMessages.printMessageWithNewLine("\nNerasta jokių biudžeto išlaidų įrašų.");
                } else {
                    for (String string : inputFromCSV) {
                        readFromCSV(budgetExpensesRecordsList, string, expensesRecordsCount);
                        expensesRecordsCount++;
                    }

                    if (BudgetListSizeResolver.checkIfEmpty(budgetExpensesRecordsList)) {
                        PrintMessages.printMessageWithNewLine
                                ("\nNepavyko apdoroti nei vieno biudžeto išlaidų įrašo.");
                    } else {
                        DisplayExpensesRecords.printExpensesRecords(budgetExpensesRecordsList);
                    }

                    expensesRecordsCount = 1;
                }
            }
        } catch (IOException exception) {
            PrintMessages.printMessageWithNewLine
                    ("\nĮvyko klaida, bandant gauti biudžeto išlaidų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }

    private void readFromCSV(List<BudgetRecord> budgetExpensesRecordsList, final String string,
                             final int expensesRecordsCount) {
        final String[] budgetRecordStrings = string.split(",");
        if (budgetRecordStrings.length != 7) {
            final ExpensesRecord expensesRecord = expensesCSVReadTransformer.
                    transformFromCSV(budgetRecordStrings);
            if (expensesRecord != null) {
                budgetExpensesRecordsList.add(expensesRecord);
            } else {
                PrintMessages.printMessageWithoutNewLine(
                        String.format("\nĮvyko klaida apdorojant %d biudžeto išlaidų įrašą iš CSV failo.\n",
                                expensesRecordsCount));
            }
        }
    }

    public boolean doesExpensesFileExists() {
        return Files.exists(FILE_PATH);
    }
}
