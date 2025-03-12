package project.budget.services.files.write.all;

import project.budget.services.files.write.expenses.WriteExpensesToFileService;
import project.budget.services.files.write.income.WriteIncomeToFileService;
import project.budget.utils.BudgetListSizeResolver;
import project.budget.utils.PrintMessages;
import project.domain.parent.BudgetRecord;
import java.util.List;

public final class WriteAllToFileService {
    private final WriteIncomeToFileService writeIncomeToFileService = new WriteIncomeToFileService();
    private final WriteExpensesToFileService writeExpensesToFileService = new WriteExpensesToFileService();

    public void writeAllToCSV(final List<BudgetRecord> budgetRecordsList) {
        if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių biudžeto pajamų ir išlaidų įrašų, kuriuos būtų galima išsaugoti.");
        } else {
            writeIncomeToFileService.writeIncomeToCSV(budgetRecordsList);
            writeExpensesToFileService.writeExpensesToCSV(budgetRecordsList);
        }
    }
}
