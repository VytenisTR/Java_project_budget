package project.budget.services;

import project.budget.utils.ExpensesRecordIndexByIdResolver;
import project.budget.utils.IncomeRecordIndexByIdResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import project.domain.interfaces.IdInput;
import project.input.record_id.ExpensesIdToBeRemovedInput;
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
