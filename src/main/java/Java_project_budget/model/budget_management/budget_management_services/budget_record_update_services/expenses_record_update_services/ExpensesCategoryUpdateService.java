package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.user_input_validators.expenses_record_validators.ExpensesCategoryValidator;

public final class ExpensesCategoryUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesCategoryValidator expensesCategoryValidator = new ExpensesCategoryValidator();

    public void updateExpensesCategory(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė išlaidų kategorijos reikšmė: %s\n", expensesRecord.getCategory());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setCategory(expensesCategoryValidator.enterExpensesCategory());
                System.out.println("\nNauja išlaidų kategorijos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nIšlaidų kategorijos reikšmė nebuvo redaguota.");
        }
    }
}
