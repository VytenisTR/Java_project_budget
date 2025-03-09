package Java_project_budget.model.budget.utils;

import Java_project_budget.model.budget.services.files.utils.FileWriteUtilities;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class DisplayExpensesRecords {

    public static void printExpensesRecords(List<BudgetRecord> budgetRecordsList) {
        if (!FileWriteUtilities.checkIfExpensesRecordExists(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžetų išlaidų įrašų.");
        } else {
            PrintMessages.printMessageWithNewLine("\nBiudžeto išlaidų įrašų sąrašas:");

            for (BudgetRecord budgetRecord : budgetRecordsList) {
                if (budgetRecord instanceof ExpensesRecord) {
                    PrintMessages.printMessageWithNewLine(budgetRecord.toString());
                }
            }
        }
    }
}
