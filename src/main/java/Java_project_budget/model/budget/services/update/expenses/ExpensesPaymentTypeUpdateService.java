package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.expenses.ExpensesPaymentTypeInput;

public final class ExpensesPaymentTypeUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesPaymentTypeInput expensesPaymentTypeInput = new ExpensesPaymentTypeInput();

    public void updateExpensesPaymentType(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė atsiskaitymo būdo įrašo reikšmė: %s\n",
                expensesRecord.getPaymentType().getPrintLT()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setPaymentType(expensesPaymentTypeInput.enterPaymentType());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja atsiskaitymo būdo įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nAtsiskaitymo būdo įrašo reikšmė nebuvo redaguota.");
        }
    }
}
