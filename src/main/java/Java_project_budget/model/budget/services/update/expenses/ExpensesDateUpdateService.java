package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.expenses.date.ExpensesDateTimeInput;

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
