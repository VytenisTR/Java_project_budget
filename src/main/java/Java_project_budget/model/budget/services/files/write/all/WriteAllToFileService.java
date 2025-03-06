package Java_project_budget.model.budget.services.files.write.all;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVWriteTransformer;
import Java_project_budget.model.budget.services.files.transformers.IncomeCSVWriteTransformer;
import Java_project_budget.model.budget.utils.BudgetListSizeResolver;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class WriteAllToFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetRecords.csv");
    private final IncomeCSVWriteTransformer incomeCSVWriteTransformer = new IncomeCSVWriteTransformer();
    private final ExpensesCSVWriteTransformer expensesCSVWriteTransformer = new ExpensesCSVWriteTransformer();

    public void writeAllToCSV(final List<BudgetRecord> budgetRecordsList) {
        if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
            System.out.println("\nNėra jokių įrašų, kuriuos būtų galima išsaugoti.");
        } else {
            try {
                Files.createDirectories(FILE_PATH.getParent());
                for (BudgetRecord budgetRecord : budgetRecordsList) {
                    if (budgetRecord instanceof IncomeRecord) {
                        final String contentToWrite = incomeCSVWriteTransformer.
                                transformToCSV((IncomeRecord) budgetRecord);
                        Files.writeString(FILE_PATH, contentToWrite,
                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    } else {
                        final String contentToWrite = expensesCSVWriteTransformer.
                                transformToCSV((ExpensesRecord) budgetRecord);
                        Files.writeString(FILE_PATH, contentToWrite,
                                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    }
                }
                System.out.println("\nBiudžeto pajamų ir išlaidų įrašai buvo išsaugoti šiame kataloge: " +
                        FILE_PATH);
            } catch (IOException exception) {
                System.out.println("\nĮvyko klaida, bandant išsaugoti biudžeto pajamų ir išlaidų įrašus. " +
                        "Klaidos aprašymas pateikiamas žemiau.\n" + exception.getMessage());
            }
        }
    }
}
