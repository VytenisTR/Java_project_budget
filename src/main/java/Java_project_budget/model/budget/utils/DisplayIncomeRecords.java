package Java_project_budget.model.budget.utils;

import Java_project_budget.model.budget.services.files.utils.FileWriteUtilities;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class DisplayIncomeRecords {

    public static void printIncomeRecords(List<BudgetRecord> budgetRecordsList) {
        if (!FileWriteUtilities.checkIfIncomeRecordExists(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžetų pajamų įrašų.");
        } else {
            PrintMessages.printMessageWithNewLine("\nBiudžeto pajamų įrašų sąrašas:");

            for (BudgetRecord budgetRecord : budgetRecordsList) {
                if (budgetRecord instanceof IncomeRecord) {
                    PrintMessages.printMessageWithNewLine(budgetRecord.toString());
                }
            }
        }
    }
}
