package project.budget.services.update;

import project.budget.services.update.expenses.ExpensesRecordUpdateService;
import project.budget.services.update.income.IncomeRecordUpdateService;
import project.budget.utils.ExpensesRecordIndexByIdResolver;
import project.budget.utils.IncomeRecordIndexByIdResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import project.domain.interfaces.IdInput;
import project.input.record_id.ExpensesIdToBeUpdatedInput;
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
