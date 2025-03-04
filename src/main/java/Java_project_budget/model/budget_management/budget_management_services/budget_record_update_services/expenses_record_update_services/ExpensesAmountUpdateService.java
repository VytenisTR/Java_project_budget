package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.user_input_validators.expenses_record_validators.ExpensesAmountValidator;

public final class ExpensesAmountUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesAmountValidator expensesAmountValidator = new ExpensesAmountValidator();

    public void updateExpensesAmount(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė išlaidų sumos reikšmė: %.2f\n", expensesRecord.getAmount());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setAmount(expensesAmountValidator.enterAmount());
                System.out.println("\nNauja išlaidų sumos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nIšlaidų sumos reikšmė nebuvo redaguota.");
        }
    }
}
