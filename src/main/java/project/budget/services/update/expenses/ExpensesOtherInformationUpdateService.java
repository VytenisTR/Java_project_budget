package project.budget.services.update.expenses;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.input.expenses.ExpensesOtherInformationInput;

public final class ExpensesOtherInformationUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesOtherInformationInput expensesOtherInformationInput = new ExpensesOtherInformationInput();

    public void updateExpensesOtherInformation(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė papildomos informacijos įrašo reikšmė: %s\n",
                expensesRecord.getOtherInformation()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setOtherInformation(expensesOtherInformationInput.enterOtherInformation());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja papildomos informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nPapildomos informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
