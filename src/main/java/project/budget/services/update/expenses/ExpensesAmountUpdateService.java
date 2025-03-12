package project.budget.services.update.expenses;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.input.expenses.ExpensesAmountInput;

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
