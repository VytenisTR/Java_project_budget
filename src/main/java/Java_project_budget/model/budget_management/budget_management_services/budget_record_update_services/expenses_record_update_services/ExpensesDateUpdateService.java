package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.user_input_validators.common_validators.date_time_validator.DateTimeValidator;

public final class ExpensesDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final DateTimeValidator dateTimeValidator = new DateTimeValidator();

    public void updateExpensesDate(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė išlaidų įrašo datos reikšmė: %s\n", expensesRecord.getDate());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setDate(dateTimeValidator.enterDateTime());
                System.out.println("\nNauja išlaidų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nIšlaidų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
