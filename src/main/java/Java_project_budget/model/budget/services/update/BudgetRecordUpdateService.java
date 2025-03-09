package Java_project_budget.model.budget.services.update;

import Java_project_budget.model.budget.services.update.expenses.ExpensesRecordUpdateService;
import Java_project_budget.model.budget.services.update.income.IncomeRecordUpdateService;
import Java_project_budget.model.budget.utils.BudgetRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.domain.interfaces.IdInput;
import Java_project_budget.model.input.record_id.IncomeIdToBeUpdatedInput;
import java.util.List;

public final class BudgetRecordUpdateService {
    private final IncomeRecordUpdateService incomeRecordUpdateService = new IncomeRecordUpdateService();
    private final ExpensesRecordUpdateService expensesRecordUpdateService = new ExpensesRecordUpdateService();

    public void updateBudgetRecord(List<BudgetRecord> budgetRecordList, final IdInput idInput) {
        int budgetRecordIndex = BudgetRecordIndexByIdResolver.getBudgetRecordIndex(budgetRecordList,
                idInput.enterId());
        int budgetRecordType = idInput instanceof IncomeIdToBeUpdatedInput ? 1 : 0;

        if (budgetRecordIndex != -1 && budgetRecordType == 1) {
            incomeRecordUpdateService.
                    updateIncomeRecord((IncomeRecord) budgetRecordList.get(budgetRecordIndex));
        } else if (budgetRecordIndex != -1) {
            expensesRecordUpdateService.
                    updateExpensesRecord((ExpensesRecord) budgetRecordList.get(budgetRecordIndex));
        } else {
            PrintMessages.printMessageWithNewLine
                    ("\nJūsų nurodytas unikalus įrašo numeris neegzistuoja!");
        }
    }
}
