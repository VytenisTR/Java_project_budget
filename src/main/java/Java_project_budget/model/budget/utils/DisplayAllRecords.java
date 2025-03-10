package Java_project_budget.model.budget.utils;

import Java_project_budget.model.budget.services.files.utils.BudgetRecordExistanceResolver;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class DisplayAllRecords {

    public static void printAllRecords(List<BudgetRecord> budgetRecordsList) {
        if (BudgetRecordExistanceResolver.checkIfIncomeRecordExists(budgetRecordsList) &&
                BudgetRecordExistanceResolver.checkIfExpensesRecordExists(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžetų pajamų ar išlaidų įrašų.");
        } else {
            PrintMessages.printMessageWithNewLine("\nBiudžeto pajamų ir išlaidų įrašų sąrašas:");

            for (BudgetRecord budgetRecord : budgetRecordsList) {
                PrintMessages.printMessageWithNewLine(budgetRecord.toString());
            }
        }
    }
}
