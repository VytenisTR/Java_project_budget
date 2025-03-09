package Java_project_budget.model.budget.services.files.read.all;

import Java_project_budget.model.budget.services.files.read.expenses.ReadExpensesFromFileService;
import Java_project_budget.model.budget.services.files.read.income.ReadIncomeFromFileService;
import Java_project_budget.model.budget.utils.PrintMessages;

public final class ReadAllFromFileService {
    private final ReadIncomeFromFileService readIncomeFromFileService = new ReadIncomeFromFileService();
    private final ReadExpensesFromFileService readExpensesFromFileService = new ReadExpensesFromFileService();

    public void readAllFromCSV() {
        if (!readIncomeFromFileService.doesIncomeFileExist() &&
                !readExpensesFromFileService.doesExpensesFileExists()) {
            PrintMessages.printMessageWithNewLine("\nDuomenų failai neegzistuoja.");
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
}
