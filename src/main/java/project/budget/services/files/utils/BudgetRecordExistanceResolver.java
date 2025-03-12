package project.budget.services.files.utils;

import project.domain.data.ExpensesRecord;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetRecordExistanceResolver {

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
