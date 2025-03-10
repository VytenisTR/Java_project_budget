package Java_project_budget.model.budget.services.files.read.income;

import Java_project_budget.model.budget.services.files.transformers.IncomeCSVReadTransformer;
import Java_project_budget.model.budget.utils.BudgetListSizeResolver;
import Java_project_budget.model.budget.utils.DisplayIncomeRecords;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ReadIncomeFromFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetIncomeRecords.csv");
    private final IncomeCSVReadTransformer incomeCSVReadTransformer = new IncomeCSVReadTransformer();

    public void readIncomeFromCSV() {
        List<BudgetRecord> budgetIncomeRecordsList = new ArrayList<>();
        int incomeRecordsCount = 1;

        try {
            if (!doesIncomeFileExist()) {
                PrintMessages.printMessageWithNewLine("\nDuomenų failas neegzistuoja.");
            } else {
                final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

                if (inputFromCSV.isEmpty()) {
                    PrintMessages.printMessageWithNewLine("\nNerasta jokių biudžeto pajamų įrašų.");
                } else {
                    for (String string : inputFromCSV) {
                        readFromCSV(budgetIncomeRecordsList, string, incomeRecordsCount);
                        incomeRecordsCount++;
                    }

                    if (BudgetListSizeResolver.checkIfEmpty(budgetIncomeRecordsList)) {
                        PrintMessages.printMessageWithNewLine
                                ("\nNepavyko apdoroti nei vieno biudžeto pajamų įrašo.");
                    } else {
                        DisplayIncomeRecords.printIncomeRecords(budgetIncomeRecordsList);
                    }

                    incomeRecordsCount = 1;
                }
            }
        } catch (IOException exception) {
            PrintMessages.printMessageWithNewLine
                    ("\nĮvyko klaida, bandant gauti biudžeto pajamų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }

    private void readFromCSV(List<BudgetRecord> budgetIncomeRecordsList, final String string,
                             final int incomeRecordsCount) {
        final String[] budgetRecordStrings = string.split(",");
        if (budgetRecordStrings.length == 7) {
            final IncomeRecord incomeRecord = incomeCSVReadTransformer.transformFromCSV(budgetRecordStrings);
            if (incomeRecord != null) {
                budgetIncomeRecordsList.add(incomeRecord);
            } else {
                PrintMessages.printMessageWithoutNewLine(
                        String.format("\nĮvyko klaida apdorojant %d biudžeto pajamų įrašą iš CSV failo.\n",
                                incomeRecordsCount));
            }
        }
    }

    public boolean doesIncomeFileExist() {
        return Files.exists(FILE_PATH);
    }
}
