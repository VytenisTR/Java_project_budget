package project.budget.services.update.expenses;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.input.expenses.date.ExpensesDateTimeInput;

public final class ExpensesDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesDateTimeInput expensesDateTimeInput = new ExpensesDateTimeInput();

    public void updateExpensesDate(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė išlaidų įrašo datos reikšmė: %s\n", expensesRecord.getDate()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setDate(expensesDateTimeInput.enterDateTime());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja išlaidų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nIšlaidų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
