package Java_project_budget.model.budget_management.budget_management_utilities;

import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import java.util.List;

public final class DisplayIncomeRecords {

    public static void printIncomeRecords(List<BudgetRecord> budgetRecordsList) {
        System.out.println("\nBiudžeto pajamų įrašų sąrašas:");

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                System.out.println(budgetRecord);
            }
        }
    }
}
