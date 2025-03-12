package project.budget.services.files.read.expenses;

import project.budget.services.files.transformers.ExpensesCSVReadTransformer;
import project.budget.utils.BudgetListSizeResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ReadExpensesFromFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetExpensesRecords.csv");
    private final ExpensesCSVReadTransformer expensesCSVReadTransformer = new ExpensesCSVReadTransformer();

    public void readExpensesFromCSV(List<BudgetRecord> budgetRecordsList) {
        List<BudgetRecord> budgetExpensesRecordsList = new ArrayList<>();
        int expensesRecordsCount = 1;

        try {
            if (!doesExpensesFileExists()) {
                PrintMessages.printMessageWithNewLine("\nBiudžeto išlaidų duomenų failas neegzistuoja.");
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
                        addExpensesRecordsToBudget(budgetExpensesRecordsList, budgetRecordsList);
                        PrintMessages.printMessageWithNewLine
                                ("\nBiudžeto išlaidų įrašai buvo sėkmingai įkelti.");
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

    private void addExpensesRecordsToBudget(final List<BudgetRecord> budgetExpensesRecordsList, List<BudgetRecord> budgetRecordsList) {
        for (BudgetRecord budgetRecord : budgetExpensesRecordsList) {
            budgetRecordsList.add(budgetRecord);
        }
    }

    public boolean doesExpensesFileExists() {
        return Files.exists(FILE_PATH);
    }
}
