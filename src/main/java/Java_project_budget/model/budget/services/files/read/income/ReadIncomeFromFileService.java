package Java_project_budget.model.budget.services.files.read.income;

import Java_project_budget.model.budget.services.files.transformers.IncomeCSVReadTransformer;
import Java_project_budget.model.budget.utils.DisplayIncomeRecords;
import Java_project_budget.model.budget.utils.PrintMessages;
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

        try {
            if (!doesIncomeFileExist()) {
                PrintMessages.printMessageWithNewLine("\nDuomenų failas neegzistuoja.");
            } else {
                final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

                if (inputFromCSV.isEmpty()) {
                    PrintMessages.printMessageWithNewLine("\nNerasta jokių biudžeto pajamų įrašų.");
                } else {
                    for (String string : inputFromCSV) {
                        readFromCSV(budgetIncomeRecordsList, string);
                    }

                    DisplayIncomeRecords.printIncomeRecords(budgetIncomeRecordsList);
                }
            }
        } catch (IOException exception) {
            PrintMessages.printMessageWithNewLine
                    ("\nĮvyko klaida, bandant gauti biudžeto pajamų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }

    private void readFromCSV(List<BudgetRecord> budgetIncomeRecordsList, String string) {
        final String[] budgetRecordStrings = string.split(",");
        if (budgetRecordStrings.length == 7) {
            budgetIncomeRecordsList.add(incomeCSVReadTransformer.transformFromCSV(budgetRecordStrings));
        }
    }

    public boolean doesIncomeFileExist() {
        return Files.exists(FILE_PATH);
    }
}
