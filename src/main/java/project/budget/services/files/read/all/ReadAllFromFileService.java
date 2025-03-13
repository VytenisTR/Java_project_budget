package project.budget.services.files.read.all;

import project.budget.services.files.read.expenses.ReadExpensesFromFileService;
import project.budget.services.files.read.income.ReadIncomeFromFileService;
import project.budget.utils.PrintMessages;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class ReadAllFromFileService {
    private final ReadIncomeFromFileService readIncomeFromFileService = new ReadIncomeFromFileService();
    private final ReadExpensesFromFileService readExpensesFromFileService = new ReadExpensesFromFileService();

    public void readAllFromCSV() {
        if (!readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            PrintMessages.printMessageWithNewLine
                    ("\nBiudžeto pajamų ir išlaidų duomenų failai neegzistuoja.");
        } else if (readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            readIncomeFromFileService.readIncomeFromCSV();
        } else if (!readIncomeFromFileService.doesIncomeFileExist() &&
                readExpensesFromFileService.doesExpensesFileExists()) {
            readExpensesFromFileService.readExpensesFromCSV();
        } else {
            readIncomeFromFileService.readIncomeFromCSV();
            readExpensesFromFileService.readExpensesFromCSV();
        }
    }

    public void readAllFromCSVOnStart(List<BudgetRecord> budgetRecordsList) {
        if (!readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            PrintMessages.printMessageWithNewLine
                    ("\nBiudžeto pajamų ir išlaidų duomenų failai neegzistuoja.");
        } else if (readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            readIncomeFromFileService.readIncomeFromCSVOnStart(budgetRecordsList);
        } else if (!readIncomeFromFileService.doesIncomeFileExist() &&
                readExpensesFromFileService.doesExpensesFileExists()) {
            readExpensesFromFileService.readExpensesFromCSVOnStart(budgetRecordsList);
        } else {
            readIncomeFromFileService.readIncomeFromCSVOnStart(budgetRecordsList);
            readExpensesFromFileService.readExpensesFromCSVOnStart(budgetRecordsList);
        }
    }
}
