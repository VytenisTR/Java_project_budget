package Java_project_budget.model.budget.utils;

import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetRecordIndexByIdResolver {

    public static int getBudgetRecordIndex(final List<BudgetRecord> budgetRecordsList, final int budgetRecordId) {
        int result = -1;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if(budgetRecord.getId() == budgetRecordId) {
                result = budgetRecordsList.indexOf(budgetRecord);
                break;
            }
        }

        return result;
    }
}
