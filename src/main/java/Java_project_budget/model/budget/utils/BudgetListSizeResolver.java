package Java_project_budget.model.budget.utils;

import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetListSizeResolver {

    public static boolean checkIfEmpty(final List<BudgetRecord> budgetRecordsList) {
        return budgetRecordsList.isEmpty();
    }
}
