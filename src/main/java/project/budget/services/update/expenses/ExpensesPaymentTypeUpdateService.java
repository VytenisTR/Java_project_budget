package project.budget.services.update.expenses;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.input.expenses.ExpensesPaymentTypeUpdateInput;

public final class ExpensesPaymentTypeUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesPaymentTypeUpdateInput expensesPaymentTypeUpdateInput =
            new ExpensesPaymentTypeUpdateInput();

    public void updateExpensesPaymentType(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė atsiskaitymo būdo įrašo reikšmė: %s\n",
                expensesRecord.getPaymentType().getPrintLT()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setPaymentType(expensesPaymentTypeUpdateInput.enterPaymentType());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja atsiskaitymo būdo įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nAtsiskaitymo būdo įrašo reikšmė nebuvo redaguota.");
        }
    }
}
