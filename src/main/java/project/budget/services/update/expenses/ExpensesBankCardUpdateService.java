package project.budget.services.update.expenses;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.ExpensesRecord;
import project.input.bankcard.BankCardInput;

public final class ExpensesBankCardUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final BankCardInput bankCardInput = new BankCardInput();

    public void updateExpensesBankCard(ExpensesRecord expensesRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė banko kortelės numerio reikšmė: %s\n\n" +
                "Dabartinė banko kortelės tipo reikšmė: %s\n",
                expensesRecord.getBankCard().getNumber(),
                expensesRecord.getBankCard().getCardType().getPrintLT()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setBankCardInfo(bankCardInput.enterBankCard());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja banko kortelės informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nBanko kortelės informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
