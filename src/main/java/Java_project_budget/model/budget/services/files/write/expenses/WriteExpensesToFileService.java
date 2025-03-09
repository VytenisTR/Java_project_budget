package Java_project_budget.model.budget.services.files.write.expenses;

import Java_project_budget.model.budget.services.files.transformers.ExpensesCSVWriteTransformer;
import Java_project_budget.model.budget.services.files.utils.FileWriteUtilities;
import Java_project_budget.model.budget.utils.BudgetListSizeResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class WriteExpensesToFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetExpensesRecords.csv");
    private final ExpensesCSVWriteTransformer expensesCSVWriteTransformer = new ExpensesCSVWriteTransformer();

    public void writeExpensesToCSV(final List<BudgetRecord> budgetRecordsList) {
        if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių įrašų, kuriuos būtų galima išsaugoti.");
        } else if (!FileWriteUtilities.checkIfExpensesRecordExists(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžeto išlaidų įrašų, kuriuos būtų galima išsaugoti.");
        } else {
            try {
                Files.createDirectories(FILE_PATH.getParent());

                for (BudgetRecord budgetRecord : budgetRecordsList) {
                    saveToCSV(budgetRecord);
                }

                PrintMessages.printMessageWithNewLine
                        ("\nBiudžeto išlaidų įrašai buvo išsaugoti šiame kataloge: " + FILE_PATH);
            } catch (IOException exception) {
                PrintMessages.printMessageWithNewLine("\nĮvyko klaida, bandant išsaugoti biudžeto išlaidų įrašus. " +
                        "Klaidos aprašymas pateikiamas žemiau.\n" + exception.getMessage());
            }
        }
    }

    private void saveToCSV(final BudgetRecord budgetRecord) throws IOException {
        if (budgetRecord instanceof ExpensesRecord) {
            final String contentToWrite = expensesCSVWriteTransformer.
                    transformToCSV((ExpensesRecord) budgetRecord);
            Files.writeString(FILE_PATH, contentToWrite,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}
