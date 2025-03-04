package Java_project_budget.model.budget_management.budget_management_utilities;

import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import java.util.List;

public final class BudgetRecordIndexById {

    public static int getBudgetRecordIndex(List<BudgetRecord> budgetRecordsList, int budgetRecordId) {
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
