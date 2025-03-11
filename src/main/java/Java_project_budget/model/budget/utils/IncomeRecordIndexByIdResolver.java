package Java_project_budget.model.budget.utils;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
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
