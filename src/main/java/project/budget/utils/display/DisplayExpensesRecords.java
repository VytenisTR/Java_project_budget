package project.budget.utils.display;

import project.budget.services.files.utils.BudgetRecordExistanceResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class DisplayExpensesRecords {

    public static void printExpensesRecords(List<BudgetRecord> budgetRecordsList) {
        if (!BudgetRecordExistanceResolver.checkIfExpensesRecordExists(budgetRecordsList)) {
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
