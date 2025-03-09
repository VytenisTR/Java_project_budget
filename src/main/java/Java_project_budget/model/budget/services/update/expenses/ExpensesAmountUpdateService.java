package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.expenses.ExpensesAmountInput;

public final class ExpensesAmountUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesAmountInput expensesAmountInput = new ExpensesAmountInput();

    public void updateExpensesAmount(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė išlaidų sumos reikšmė: %.2f\n", expensesRecord.getAmount()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setAmount(expensesAmountInput.enterAmount());
                PrintMessages.printMessageWithNewLine("\nNauja išlaidų sumos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine("\nIšlaidų sumos reikšmė nebuvo redaguota.");
        }
    }
}
