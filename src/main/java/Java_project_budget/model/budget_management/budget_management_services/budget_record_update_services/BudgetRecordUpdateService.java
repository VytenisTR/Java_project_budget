package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services;

import Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services.ExpensesRecordUpdateService;
import Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services.IncomeRecordUpdateService;
import Java_project_budget.model.budget_management.budget_management_utilities.BudgetRecordIndexById;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import Java_project_budget.model.user_input_validators.abstract_validators.RecordIdValidator;
import java.util.List;

public final class BudgetRecordUpdateService {
    private final IncomeRecordUpdateService incomeRecordUpdateService = new IncomeRecordUpdateService();
    private final ExpensesRecordUpdateService expensesRecordUpdateService = new ExpensesRecordUpdateService();

    public void updateBudgetRecord(List<BudgetRecord> budgetRecordList, RecordIdValidator recordIdValidator) {
        int budgetRecordIndex = BudgetRecordIndexById.getBudgetRecordIndex(budgetRecordList,
                recordIdValidator.enterId());

        if(budgetRecordIndex != -1 && budgetRecordList.get(budgetRecordIndex) instanceof IncomeRecord) {
            incomeRecordUpdateService.
                    updateIncomeRecord((IncomeRecord) budgetRecordList.get(budgetRecordIndex));
        } else if (budgetRecordIndex != -1 && budgetRecordList.get(budgetRecordIndex) instanceof ExpensesRecord) {
            expensesRecordUpdateService.
                    updateExpensesRecord((ExpensesRecord) budgetRecordList.get(budgetRecordIndex));
        }
    }
}
