package project.budget.utils.display;

import project.budget.services.files.utils.BudgetRecordExistanceResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class DisplayIncomeRecords {

    public static void printIncomeRecords(List<BudgetRecord> budgetRecordsList) {
        if (!BudgetRecordExistanceResolver.checkIfIncomeRecordExists(budgetRecordsList)) {
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
