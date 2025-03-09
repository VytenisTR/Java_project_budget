package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.expenses.ExpensesCategoryInput;

public final class ExpensesCategoryUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesCategoryInput expensesCategoryInput = new ExpensesCategoryInput();

    public void updateExpensesCategory(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė išlaidų kategorijos reikšmė: %s\n",
                        expensesRecord.getCategory().getPrintLT()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setCategory(expensesCategoryInput.enterExpensesCategory());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja išlaidų kategorijos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nIšlaidų kategorijos reikšmė nebuvo redaguota.");
        }
    }
}
