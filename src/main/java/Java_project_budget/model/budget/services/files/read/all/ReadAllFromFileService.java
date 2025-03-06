package Java_project_budget.model.budget.services.files.read.all;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVReadTransformer;
import Java_project_budget.model.budget.services.files.transformers.IncomeCSVReadTransformer;
import Java_project_budget.model.budget.utils.DisplayAllRecords;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ReadAllFromFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetRecords.csv");
    private final IncomeCSVReadTransformer incomeCSVReadTransformer = new IncomeCSVReadTransformer();
    private final ExpensesCSVReadTransformer expensesCSVReadTransformer = new ExpensesCSVReadTransformer();

    public void readAllFromCSV() {
        List<BudgetRecord> budgetRecordsList = new ArrayList<>();

        try {
            final List<String> inputFromCSV = Files.readAllLines(FILE_PATH);

            if (inputFromCSV.isEmpty()) {
                System.out.println("\nNerasta jokių įrašų.");
            } else {
                for (String string : inputFromCSV) {
                    final String[] budgetRecordStrings = string.split(",");
                    if (budgetRecordStrings.length == 6) {
                        budgetRecordsList.add(incomeCSVReadTransformer.transformFromCSV(budgetRecordStrings));
                    } else {
                        budgetRecordsList.add(expensesCSVReadTransformer.transformFromCSV(budgetRecordStrings));
                    }
                }
                DisplayAllRecords.printAllRecords(budgetRecordsList);
            }
        } catch (IOException exception) {
            System.out.println("\nĮvyko klaida, bandant gauti biudžeto pajamų ir išlaidų įrašus. " +
                    "Klaidos aprašymas pateikimas žemiau.\n" + exception.getMessage());
        }


    }
}
