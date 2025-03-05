package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services;

import Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services.ExpensesRecordUpdateService;
import Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services.IncomeRecordUpdateService;
import Java_project_budget.model.budget_management.budget_management_utilities.BudgetRecordIndexById;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import Java_project_budget.model.user_input_validators.abstract_validators.RecordIdValidator;
import Java_project_budget.model.user_input_validators.common_validators.record_id_validators.IncomeIdToBeUpdatedValidator;

import java.util.List;

public final class BudgetRecordUpdateService {
    private final IncomeRecordUpdateService incomeRecordUpdateService = new IncomeRecordUpdateService();
    private final ExpensesRecordUpdateService expensesRecordUpdateService = new ExpensesRecordUpdateService();

    public void updateBudgetRecord(List<BudgetRecord> budgetRecordList, RecordIdValidator recordIdValidator) {
        int budgetRecordIndex = BudgetRecordIndexById.getBudgetRecordIndex(budgetRecordList,
                recordIdValidator.enterId());
        int budgetRecordType = recordIdValidator instanceof IncomeIdToBeUpdatedValidator ? 1 : 0;

        if (budgetRecordIndex != -1 && budgetRecordType == 1) {
            incomeRecordUpdateService.
                    updateIncomeRecord((IncomeRecord) budgetRecordList.get(budgetRecordIndex));
        } else if (budgetRecordIndex != -1) {
            expensesRecordUpdateService.
                    updateExpensesRecord((ExpensesRecord) budgetRecordList.get(budgetRecordIndex));
        } else {
            System.out.println("\nJūsų nurodytas unikalus įrašo numeris neegzistuoja!");
        }
    }
}
