package Java_project_budget.model.budget.services.update;

import Java_project_budget.model.budget.services.update.expenses.ExpensesRecordUpdateService;
import Java_project_budget.model.budget.services.update.income.IncomeRecordUpdateService;
import Java_project_budget.model.budget.utils.ExpensesRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.IncomeRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.domain.interfaces.IdInput;
import Java_project_budget.model.input.record_id.ExpensesIdToBeUpdatedInput;
import java.util.List;

public final class BudgetRecordUpdateService {
    private final IncomeRecordUpdateService incomeRecordUpdateService = new IncomeRecordUpdateService();
    private final ExpensesRecordUpdateService expensesRecordUpdateService = new ExpensesRecordUpdateService();

    public void updateBudgetRecord(List<BudgetRecord> budgetRecordsList, final IdInput idInput) {
        final int budgetRecordIndex;
        final int budgetRecordType = idInput instanceof ExpensesIdToBeUpdatedInput ? 1 : 0;

        switch (budgetRecordType) {
            case 0 -> {
                budgetRecordIndex = IncomeRecordIndexByIdResolver.getIncomeRecordIndex(budgetRecordsList,
                        idInput.enterId());
                if (budgetRecordIndex != -1) {
                    incomeRecordUpdateService.
                            updateIncomeRecord((IncomeRecord) budgetRecordsList.get(budgetRecordIndex));
                } else {
                    PrintMessages.printMessageWithNewLine
                            ("\nBiudžeto pajamų įrašas su Jūsų nurodytu unikaliu įrašo numeriu neegzistuoja!");
                }
            }
            case 1 -> {
                budgetRecordIndex = ExpensesRecordIndexByIdResolver.getExpensesRecordIndex(budgetRecordsList,
                        idInput.enterId());
                if (budgetRecordIndex != -1) {
                    expensesRecordUpdateService.
                            updateExpensesRecord((ExpensesRecord) budgetRecordsList.get(budgetRecordIndex));
                } else {
                    PrintMessages.printMessageWithNewLine
                            ("\nBiudžeto išlaidų įrašas su Jūsų nurodytu unikaliu įrašo numeriu neegzistuoja!");
                }
            }
        }
    }
}
