package Java_project_budget.model.budget;

import Java_project_budget.model.budget.meniu.expenses.ExpensesMeniuResolver;
import Java_project_budget.model.budget.meniu.files.FilesMeniuResolver;
import Java_project_budget.model.budget.meniu.income.IncomeMeniuResolver;
import Java_project_budget.model.budget.services.BudgetRecordsListServices;
import Java_project_budget.model.budget.services.BudgetBalanceService;
import Java_project_budget.model.budget.services.files.read.all.ReadAllFromFileService;
import Java_project_budget.model.budget.services.files.read.expenses.ReadExpensesFromFileService;
import Java_project_budget.model.budget.services.files.read.income.ReadIncomeFromFileService;
import Java_project_budget.model.budget.services.files.write.all.WriteAllToFileService;
import Java_project_budget.model.budget.services.files.write.expenses.WriteExpensesToFileService;
import Java_project_budget.model.budget.services.files.write.income.WriteIncomeToFileService;
import Java_project_budget.model.budget.services.update.BudgetRecordUpdateService;
import Java_project_budget.model.budget.utils.DisplayExpensesRecords;
import Java_project_budget.model.budget.utils.DisplayIncomeRecords;
import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.budget.services.ExpensesRecordResolverService;
import Java_project_budget.model.budget.services.IncomeRecordResolverService;
import Java_project_budget.model.budget.meniu.budget.BudgetMeniuResolver;
import Java_project_budget.model.input.record_id.ExpensesIdToBeRemovedInput;
import Java_project_budget.model.input.record_id.ExpensesIdToBeUpdatedInput;
import Java_project_budget.model.input.record_id.IncomeIdToBeRemovedInput;
import Java_project_budget.model.input.record_id.IncomeIdToBeUpdatedInput;
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

        while(runBudgetManagement) {
            switch (budgetMeniuResolver.resolveMeniu()) {
                case 1 -> runIncomeMeniu();
                case 2 -> runExpensesMeniu();
                case 3 -> runFilesMeniu();
                case 4 -> budgetBalanceService.printBalance(budgetRecordsList);
                case 5 -> runBudgetManagement = false;
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
                case 4 -> readIncomeFromFileService.readIncomeFromCSV();
                case 5 -> readExpensesFromFileService.readExpensesFromCSV();
                case 6 -> readAllFromFileService.readAllFromCSV();
                case 7 -> runFilesMeniu = false;
            }
        }
    }
}
