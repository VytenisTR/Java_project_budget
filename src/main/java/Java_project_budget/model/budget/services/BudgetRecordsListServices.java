package Java_project_budget.model.budget.services;

import Java_project_budget.model.budget.utils.ExpensesRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.IncomeRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.domain.interfaces.IdInput;
import Java_project_budget.model.input.record_id.ExpensesIdToBeRemovedInput;
import java.util.List;

public final class BudgetRecordsListServices {

    public void addBudgetRecord(List<BudgetRecord> budgetRecordsList, final BudgetRecord budgetRecord) {
        budgetRecordsList.add(budgetRecord);

        if (budgetRecord instanceof IncomeRecord) {
            PrintMessages.printMessageWithNewLine("\nPajamų įrašas buvo sėkmingai pridėtas.");
        } else {
            PrintMessages.printMessageWithNewLine("\nIšlaidų įrašas buvo sėkmingai pridėtas.");
        }
    }

    public void removeBudgetRecord(List<BudgetRecord> budgetRecordsList,
                                   final IdInput idInput) {
        final int budgetRecordIndex;
        final int budgetRecordType = idInput instanceof ExpensesIdToBeRemovedInput ? 1 : 0;

        switch (budgetRecordType) {
            case 0 -> {
                budgetRecordIndex = IncomeRecordIndexByIdResolver.getIncomeRecordIndex(budgetRecordsList,
                        idInput.enterId());
                if (budgetRecordIndex != -1) {
                    budgetRecordsList.remove(budgetRecordsList.get(budgetRecordIndex));

                    PrintMessages.printMessageWithNewLine
                            ("\nPasirinktas pajamų įrašas buvo sėkmingai pašalintas.");
                } else {
                    PrintMessages.printMessageWithNewLine
                            ("\nBiudžeto pajamų įrašas su Jūsų nurodytu unikaliu įrašo numeriu neegzistuoja!");
                }
            }
            case 1 -> {
                budgetRecordIndex = ExpensesRecordIndexByIdResolver.getExpensesRecordIndex(budgetRecordsList,
                        idInput.enterId());
                if (budgetRecordIndex != -1) {
                    budgetRecordsList.remove(budgetRecordsList.get(budgetRecordIndex));

                    PrintMessages.printMessageWithNewLine
                            ("\nPasirinktas išlaidų įrašas buvo sėkmingai pašalintas.");
                } else {
                    PrintMessages.printMessageWithNewLine
                            ("\nBiudžeto išlaidų įrašas su Jūsų nurodytu unikaliu įrašo numeriu neegzistuoja!");
                }
            }
        }
    }
}
