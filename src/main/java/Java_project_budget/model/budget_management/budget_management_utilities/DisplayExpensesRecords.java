package Java_project_budget.model.budget_management.budget_management_utilities;

import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import java.util.List;

public final class DisplayExpensesRecords {

    public static void printExpensesRecords(List<BudgetRecord> budgetRecordsList) {
        System.out.println("Biudžeto išlaidų įrašų sąrašas:");

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof ExpensesRecord) {
                System.out.println(budgetRecord);
            }
        }
    }
}
