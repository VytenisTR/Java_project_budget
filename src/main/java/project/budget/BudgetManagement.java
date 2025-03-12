package project.budget;

import project.budget.meniu.expenses.ExpensesMeniuResolver;
import project.budget.meniu.files.FilesMeniuResolver;
import project.budget.meniu.income.IncomeMeniuResolver;
import project.budget.services.BudgetRecordsListServices;
import project.budget.services.BudgetBalanceService;
import project.budget.services.files.read.all.ReadAllFromFileService;
import project.budget.services.files.read.expenses.ReadExpensesFromFileService;
import project.budget.services.files.read.income.ReadIncomeFromFileService;
import project.budget.services.files.write.all.WriteAllToFileService;
import project.budget.services.files.write.expenses.WriteExpensesToFileService;
import project.budget.services.files.write.income.WriteIncomeToFileService;
import project.budget.services.update.BudgetRecordUpdateService;
import project.budget.utils.display.DisplayExpensesRecords;
import project.budget.utils.display.DisplayIncomeRecords;
import project.domain.parent.BudgetRecord;
import project.budget.services.ExpensesRecordResolverService;
import project.budget.services.IncomeRecordResolverService;
import project.budget.meniu.budget.BudgetMeniuResolver;
import project.input.record_id.ExpensesIdToBeRemovedInput;
import project.input.record_id.ExpensesIdToBeUpdatedInput;
import project.input.record_id.IncomeIdToBeRemovedInput;
import project.input.record_id.IncomeIdToBeUpdatedInput;
import java.util.ArrayList;
import java.util.List;

public final class BudgetManagement {
    private final List<BudgetRecord> budgetRecordsList = new ArrayList<>();
    private final BudgetMeniuResolver budgetMeniuResolver = new BudgetMeniuResolver();
    private final ExpensesMeniuResolver expensesMeniuResolver = new ExpensesMeniuResolver();
    private final IncomeMeniuResolver incomeMeniuResolver = new IncomeMeniuResolver();
    private final FilesMeniuResolver filesMeniuResolver = new FilesMeniuResolver();
    private final IncomeRecordResolverService incomeRecordResolverService = new IncomeRecordResolverService();
    private final ExpensesRecordResolverService expensesRecordResolverService = new ExpensesRecordResolverService();
    private final BudgetRecordsListServices budgetRecordsListServices = new BudgetRecordsListServices();
    private final BudgetRecordUpdateService budgetRecordUpdateService = new BudgetRecordUpdateService();
    private final BudgetBalanceService budgetBalanceService = new BudgetBalanceService();
    private final WriteIncomeToFileService writeIncomeToFileService = new WriteIncomeToFileService();
    private final WriteExpensesToFileService writeExpensesToFileService = new WriteExpensesToFileService();
    private final WriteAllToFileService writeAllToFileService = new WriteAllToFileService();
    private final ReadIncomeFromFileService readIncomeFromFileService = new ReadIncomeFromFileService();
    private final ReadExpensesFromFileService readExpensesFromFileService = new ReadExpensesFromFileService();
    private final ReadAllFromFileService readAllFromFileService = new ReadAllFromFileService();

    public void runBudgetManagement() {
        boolean runBudgetManagement = true;
        readAllFromFileService.readAllFromCSV(budgetRecordsList);

        while(runBudgetManagement) {
            switch (budgetMeniuResolver.resolveMeniu()) {
                case 1 -> runIncomeMeniu();
                case 2 -> runExpensesMeniu();
                case 3 -> runFilesMeniu();
                case 4 -> budgetBalanceService.printBalance(budgetRecordsList);
                case 5 -> {
                    writeAllToFileService.writeAllToCSV(budgetRecordsList);
                    runBudgetManagement = false;
                }
            }
        }
    }

    private void runIncomeMeniu() {
        boolean runIncomeMeniu = true;

        while(runIncomeMeniu) {
            switch (incomeMeniuResolver.resolveMeniu()) {
                case 1 -> budgetRecordsListServices.addBudgetRecord(budgetRecordsList,
                        incomeRecordResolverService.createIncomeRecord());
                case 2 -> {
                    DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);

                    budgetRecordsListServices.removeBudgetRecord(budgetRecordsList,
                            new IncomeIdToBeRemovedInput());
                }
                case 3 -> {
                    DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);

                    budgetRecordUpdateService.updateBudgetRecord(budgetRecordsList,
                            new IncomeIdToBeUpdatedInput());
                }
                case 4 -> DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);
                case 5 -> runIncomeMeniu = false;
            }
        }
    }

    private void runExpensesMeniu() {
        boolean runExpensesMeniu = true;

        while(runExpensesMeniu) {
            switch (expensesMeniuResolver.resolveMeniu()) {
                case 1 -> budgetRecordsListServices.addBudgetRecord(budgetRecordsList,
                        expensesRecordResolverService.createExpensesRecord());
                case 2 -> {
                    DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);

                    budgetRecordsListServices.removeBudgetRecord(budgetRecordsList,
                            new ExpensesIdToBeRemovedInput());
                }
                case 3 -> {
                    DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);

                    budgetRecordUpdateService.updateBudgetRecord(budgetRecordsList,
                            new ExpensesIdToBeUpdatedInput());
                }
                case 4 -> DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);
                case 5 -> runExpensesMeniu = false;
            }
        }
    }

    private void runFilesMeniu() {
        boolean runFilesMeniu = true;

        while(runFilesMeniu) {
            switch (filesMeniuResolver.resolveMeniu()) {
                case 1 -> writeIncomeToFileService.writeIncomeToCSV(budgetRecordsList);
                case 2 -> writeExpensesToFileService.writeExpensesToCSV(budgetRecordsList);
                case 3 -> writeAllToFileService.writeAllToCSV(budgetRecordsList);
                case 4 -> readIncomeFromFileService.readIncomeFromCSV(budgetRecordsList);
                case 5 -> readExpensesFromFileService.readExpensesFromCSV(budgetRecordsList);
                case 6 -> readAllFromFileService.readAllFromCSV(budgetRecordsList);
                case 7 -> runFilesMeniu = false;
            }
        }
    }
}
