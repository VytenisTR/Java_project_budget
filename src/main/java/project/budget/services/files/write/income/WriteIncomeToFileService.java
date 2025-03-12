package project.budget.services.files.write.income;

import project.budget.services.files.transformers.IncomeCSVWriteTransformer;
import project.budget.services.files.utils.BudgetRecordExistanceResolver;
import project.budget.utils.BudgetListSizeResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public final class WriteIncomeToFileService {
    private static final Path FILE_PATH = Path.of(System.getProperty("user.home"),
            "Desktop", "BudgetIncomeRecords.csv");
    private final IncomeCSVWriteTransformer incomeCSVWriteTransformer = new IncomeCSVWriteTransformer();

    public void writeIncomeToCSV(final List<BudgetRecord> budgetRecordsList) {
        if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList) ||
                !BudgetRecordExistanceResolver.checkIfIncomeRecordExists(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžeto pajamų įrašų, kuriuos būtų galima išsaugoti.");
        } else {
            try {
                Files.createDirectories(FILE_PATH.getParent());

                for (BudgetRecord budgetRecord : budgetRecordsList) {
                    saveToCSV(budgetRecord);
                }

                PrintMessages.printMessageWithNewLine
                        ("\nBiudžeto pajamų įrašai buvo išsaugoti šiame kataloge: " + FILE_PATH);
            } catch (IOException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nĮvyko klaida, bandant išsaugoti biudžeto pajamų įrašus. " +
                                "Klaidos aprašymas pateikiamas žemiau.\n" + exception.getMessage());
            }
        }
    }

    private void saveToCSV(final BudgetRecord budgetRecord) throws IOException {
        if (budgetRecord instanceof IncomeRecord) {
            final String contentToWrite = incomeCSVWriteTransformer.
                    transformToCSV((IncomeRecord) budgetRecord);
            Files.writeString(FILE_PATH, contentToWrite,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }
}
