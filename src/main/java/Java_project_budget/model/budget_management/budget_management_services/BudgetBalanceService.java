package Java_project_budget.model.budget_management.budget_management_services;

import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import java.util.List;

public final class BudgetBalanceService {

    public void printBalance(List<BudgetRecord> budgetRecordsList) {
        double balance = 0D;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                balance += ((IncomeRecord) budgetRecord).getAmount();
            } else {
                balance -= ((ExpensesRecord) budgetRecord).getAmount();
            }
        }

        System.out.printf("\nJūsų balansas yra: %.2f EUR", balance);
    }
}
