package project.budget.services;

import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class BudgetBalanceService {

    public void printBalance(final List<BudgetRecord> budgetRecordsList) {
        double balance = 0D;

        for (BudgetRecord budgetRecord : budgetRecordsList) {
            if (budgetRecord instanceof IncomeRecord) {
                balance += budgetRecord.getAmount();
            } else {
                balance -= budgetRecord.getAmount();
            }
        }

        PrintMessages.printMessageWithoutNewLine(String.format("\nJūsų balansas yra: %.2f EUR\n", balance));
    }
}
