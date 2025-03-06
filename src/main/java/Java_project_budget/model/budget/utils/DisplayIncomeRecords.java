package Java_project_budget.model.budget.utils;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
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
