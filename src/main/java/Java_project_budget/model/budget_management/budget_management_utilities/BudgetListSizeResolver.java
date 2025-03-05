package Java_project_budget.model.budget_management.budget_management_utilities;

import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import java.util.List;

public final class BudgetListSizeResolver {

    public static boolean checkIfEmpty(List<BudgetRecord> budgetRecordsList) {
        return budgetRecordsList.isEmpty() ? true : false;
    }
}
