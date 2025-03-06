package Java_project_budget.model.budget.utils;

import Java_project_budget.model.domain.parent.BudgetRecord;

import java.util.List;

public final class DisplayAllRecords {

    public static void printAllRecords(List<BudgetRecord> budgetRecordsList) {
        System.out.println("\nBiudžeto pajamų ir išlaidų įrašų sąrašas:");

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            System.out.println(budgetRecord);
        }
    }
}
