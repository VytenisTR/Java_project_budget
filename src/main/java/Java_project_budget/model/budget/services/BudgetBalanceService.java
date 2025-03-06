package Java_project_budget.model.budget.services;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetBalanceService {

    public void printBalance(final List<BudgetRecord> budgetRecordsList) {
        double balance = 0D;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                balance += budgetRecord.getAmount();
            } else {
                balance -= budgetRecord.getAmount();
            }
        }

        System.out.printf("\nJūsų balansas yra: %.2f EUR\n", balance);
    }
}
