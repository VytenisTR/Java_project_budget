package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.user_input_validators.expenses_record_validators.ExpensesPaymentTypeValidator;

public final class ExpensesPaymentTypeUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesPaymentTypeValidator expensesPaymentTypeValidator = new ExpensesPaymentTypeValidator();

    public void updateExpensesPaymentType(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė atsiskaitymo būdo įrašo reikšmė: %s\n", expensesRecord.getPaymentType());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setPaymentType(expensesPaymentTypeValidator.enterPaymentType());
                System.out.println("\nNauja atsiskaitymo būdo įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nAtsiskaitymo būdo įrašo reikšmė nebuvo redaguota.");
        }
    }
}
