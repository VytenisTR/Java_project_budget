package Java_project_budget.model.budget.services;

import Java_project_budget.model.budget.utils.BudgetRecordIndexByIdResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.domain.interfaces.IdInput;
import Java_project_budget.model.input.record_id.IncomeIdToBeRemovedInput;
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
        int budgetRecordIndex = BudgetRecordIndexByIdResolver.getBudgetRecordIndex(budgetRecordsList,
                idInput.enterId());
        int budgetRecordType = idInput instanceof IncomeIdToBeRemovedInput ? 1 : 0;

        if (budgetRecordIndex != -1) {
            budgetRecordsList.remove(budgetRecordsList.get(budgetRecordIndex));

            PrintMessages.printMessageWithNewLine(budgetRecordType == 1 ?
                    "\nPasirinktas pajamų įrašas buvo sėkmingai pašalintas." :
                    "\nPasirinktas išlaidų įrašas buvo sėkmingai pašalintas.");
        } else {
            PrintMessages.printMessageWithNewLine
                    ("\nJūsų nurodytas unikalus įrašo numeris neegzistuoja!\n");
        }
    }
}
