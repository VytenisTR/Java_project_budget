package project.budget.utils;

import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class IncomeRecordIndexByIdResolver {

    public static int getIncomeRecordIndex(final List<BudgetRecord> budgetRecordsList, final int budgetRecordId) {
        int result = -1;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                if (budgetRecord.getId() == budgetRecordId) {
                    result = budgetRecordsList.indexOf(budgetRecord);
                    break;
                }
            }
        }

        return result;
    }
}
