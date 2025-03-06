package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.bankcard.BankCardInput;

public final class ExpensesBankCardUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final BankCardInput bankCardInput = new BankCardInput();

    public void updateExpensesBankCard(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė banko kortelės numerio reikšmė: %s\n\n" +
                        "Dabartinė banko kortelės tipo reikšmė: %s\n",
                expensesRecord.getBankCard().getNumber(), expensesRecord.getBankCard().getCardType());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setBankCardInfo(bankCardInput.enterBankCard());
                System.out.println("\nNauja banko kortelės informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nBanko kortelės informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
