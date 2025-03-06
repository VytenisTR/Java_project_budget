package Java_project_budget.model.budget.services.files.read.income;

import Java_project_budget.model.budget.services.files.transformers.IncomeCSVReadTransformer;
import Java_project_budget.model.budget.services.files.utils.FileReadUtilities;
import Java_project_budget.model.budget.utils.DisplayIncomeRecords;
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
            final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

            if (inputFromCSV.isEmpty()) {
                System.out.println("\nNerasta jokių įrašų.");
            } else if (!FileReadUtilities.checkIfIncomeRecordExists(inputFromCSV)) {
                System.out.println("\nNerasta jokių biudžeto pajamų įrašų.");
            } else {
                for (String string : inputFromCSV) {
                    final String[] budgetRecordStrings = string.split(",");
                    if (budgetRecordStrings.length == 6) {
                        budgetIncomeRecordsList.add(incomeCSVReadTransformer.transformFromCSV(budgetRecordStrings));
                    }
                }
                DisplayIncomeRecords.printIncomeRecords(budgetIncomeRecordsList);
            }
        } catch (IOException exception) {
            System.out.println("\nĮvyko klaida, bandant gauti biudžeto pajamų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }
    }
}
