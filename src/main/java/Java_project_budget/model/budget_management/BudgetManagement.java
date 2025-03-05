package Java_project_budget.model.budget_management;

import Java_project_budget.model.budget_management.budget_management_services.BudgetRecordsListServices;
import Java_project_budget.model.budget_management.budget_management_services.BudgetBalanceService;
import Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.BudgetRecordUpdateService;
import Java_project_budget.model.budget_management.budget_management_utilities.BudgetListSizeResolver;
import Java_project_budget.model.budget_management.budget_management_utilities.DisplayExpensesRecords;
import Java_project_budget.model.budget_management.budget_management_utilities.DisplayIncomeRecords;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import Java_project_budget.model.budget_management.budget_management_services.ExpensesRecordResolverService;
import Java_project_budget.model.budget_management.budget_management_services.IncomeRecordResolverService;
import Java_project_budget.model.budget_management.budget_management_meniu_selection.BudgetManagementMeniuResolver;
import Java_project_budget.model.user_input_validators.common_validators.record_id_validators.ExpensesIdToBeRemovedValidator;
import Java_project_budget.model.user_input_validators.common_validators.record_id_validators.ExpensesIdToBeUpdatedValidator;
import Java_project_budget.model.user_input_validators.common_validators.record_id_validators.IncomeIdToBeRemovedValidator;
import Java_project_budget.model.user_input_validators.common_validators.record_id_validators.IncomeIdToBeUpdatedValidator;

import java.util.ArrayList;
import java.util.List;

public final class BudgetManagement {
    private final List<BudgetRecord> budgetRecordsList = new ArrayList<>();
    private final BudgetManagementMeniuResolver budgetManagementMeniuResolver = new BudgetManagementMeniuResolver();
    private final IncomeRecordResolverService incomeRecordResolverService = new IncomeRecordResolverService();
    private final ExpensesRecordResolverService expensesRecordResolverService = new ExpensesRecordResolverService();
    private final BudgetRecordsListServices budgetRecordsListServices = new BudgetRecordsListServices();
    private final BudgetRecordUpdateService budgetRecordUpdateService = new BudgetRecordUpdateService();
    private final BudgetBalanceService budgetBalanceService = new BudgetBalanceService();

    public void runBudgetManagement() {
        boolean runBudgetManagementLoop = true;

        while(runBudgetManagementLoop) {
            switch (budgetManagementMeniuResolver.resolveMeniu()) {
                case 1 -> budgetRecordsListServices.addBudgetRecord(budgetRecordsList,
                        incomeRecordResolverService.createIncomeRecord());
                case 2 -> budgetRecordsListServices.addBudgetRecord(budgetRecordsList,
                        expensesRecordResolverService.createExpensesRecord());
                case 3 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto pajamų įrašų.\n");
                    } else {
                        DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);
                        budgetRecordsListServices.removeBudgetRecord(budgetRecordsList,
                                new IncomeIdToBeRemovedValidator());
                    }
                }
                case 4 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto išlaidų įrašų.\n");
                    } else {
                        DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);
                        budgetRecordsListServices.removeBudgetRecord(budgetRecordsList,
                                new ExpensesIdToBeRemovedValidator());
                    }
                }
                case 5 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto pajamų įrašų.\n");
                    } else {
                        DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);
                        budgetRecordUpdateService.updateBudgetRecord(budgetRecordsList,
                                new IncomeIdToBeUpdatedValidator());
                    }
                }
                case 6 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto išlaidų įrašų.\n");
                    } else {
                        DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);
                        budgetRecordUpdateService.updateBudgetRecord(budgetRecordsList,
                                new ExpensesIdToBeUpdatedValidator());
                    }
                }
                case 7 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto pajamų įrašų.\n");
                    } else {
                        DisplayIncomeRecords.printIncomeRecords(budgetRecordsList);
                    }
                }
                case 8 -> {
                    if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
                        System.out.println("\nNėra jokių biudžeto išlaidų įrašų.\n");
                    } else {
                        DisplayExpensesRecords.printExpensesRecords(budgetRecordsList);
                    }
                }
                case 9 -> budgetBalanceService.printBalance(budgetRecordsList);
                case 10 -> runBudgetManagementLoop = false;
            }
        }
    }
}
