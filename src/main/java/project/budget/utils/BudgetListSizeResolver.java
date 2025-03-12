package project.budget.utils;

import project.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetListSizeResolver {

    public static boolean checkIfEmpty(final List<BudgetRecord> budgetRecordsList) {
        return budgetRecordsList.isEmpty();
    }
}
