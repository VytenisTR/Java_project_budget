package project.budget.utils;

import project.domain.data.ExpensesRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class ExpensesRecordIndexByIdResolver {

    public static int getExpensesRecordIndex(final List<BudgetRecord> budgetRecordsList, final int budgetRecordId) {
        int result = -1;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof ExpensesRecord) {
                if(budgetRecord.getId() == budgetRecordId) {
                    result = budgetRecordsList.indexOf(budgetRecord);
                    break;
                }
            }
        }

        return result;
    }
}
