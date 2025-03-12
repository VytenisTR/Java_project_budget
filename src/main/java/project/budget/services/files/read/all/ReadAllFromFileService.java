package project.budget.services.files.read.all;

import project.budget.services.files.read.expenses.ReadExpensesFromFileService;
import project.budget.services.files.read.income.ReadIncomeFromFileService;
import project.budget.utils.PrintMessages;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class ReadAllFromFileService {
    private final ReadIncomeFromFileService readIncomeFromFileService = new ReadIncomeFromFileService();
    private final ReadExpensesFromFileService readExpensesFromFileService = new ReadExpensesFromFileService();

    public void readAllFromCSV(List<BudgetRecord> budgetRecordsList) {
        if (!readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            PrintMessages.printMessageWithNewLine
                    ("\nBiudžeto pajamų ir išlaidų duomenų failai neegzistuoja.");
        } else if (readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            readIncomeFromFileService.readIncomeFromCSV(budgetRecordsList);
        } else if (!readIncomeFromFileService.doesIncomeFileExist() &&
                readExpensesFromFileService.doesExpensesFileExists()) {
            readExpensesFromFileService.readExpensesFromCSV(budgetRecordsList);
        } else {
            readIncomeFromFileService.readIncomeFromCSV(budgetRecordsList);
            readExpensesFromFileService.readExpensesFromCSV(budgetRecordsList);
        }
    }
}
