package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.user_input_validators.expenses_record_validators.bank_card_validator.BankCardValidator;

public final class ExpensesBankCardUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final BankCardValidator bankCardValidator = new BankCardValidator();

    public void updateExpensesBankCard(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė banko kortelės informacijos įrašo reikšmė:\n%s\n",
                expensesRecord.getBankCardInfo());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setBankCardInfo(bankCardValidator.enterBankCard());
                System.out.println("\nNauja banko kortelės informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nBanko kortelės informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
