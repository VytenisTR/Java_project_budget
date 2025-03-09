package Java_project_budget.model.budget.services.files.write.all;

import Java_project_budget.model.budget.services.files.write.expenses.WriteExpensesToFileService;
import Java_project_budget.model.budget.services.files.write.income.WriteIncomeToFileService;
import Java_project_budget.model.budget.utils.BudgetListSizeResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.parent.BudgetRecord;
import java.util.List;

public final class WriteAllToFileService {
    private final WriteIncomeToFileService writeIncomeToFileService = new WriteIncomeToFileService();
    private final WriteExpensesToFileService writeExpensesToFileService = new WriteExpensesToFileService();

    public void writeAllToCSV(final List<BudgetRecord> budgetRecordsList) {
        if (BudgetListSizeResolver.checkIfEmpty(budgetRecordsList)) {
            PrintMessages.printMessageWithNewLine
                    ("\nNėra jokių įrašų, kuriuos būtų galima išsaugoti.");
        } else {
            writeIncomeToFileService.writeIncomeToCSV(budgetRecordsList);
            writeExpensesToFileService.writeExpensesToCSV(budgetRecordsList);
        }
    }
}
