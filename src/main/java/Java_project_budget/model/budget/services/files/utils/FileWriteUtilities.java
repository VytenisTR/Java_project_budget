package Java_project_budget.model.budget.services.files.utils;

import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class FileWriteUtilities {

    public static boolean checkIfIncomeRecordExists(List<BudgetRecord> budgetRecordsList) {
        boolean result = false;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static boolean checkIfExpensesRecordExists(List<BudgetRecord> budgetRecordsList) {
        boolean result = false;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof ExpensesRecord) {
                result = true;
                break;
            }
        }

        return result;
    }
}
