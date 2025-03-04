package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.common_validators.date_time_validator.DateTimeValidator;

public final class IncomeDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final DateTimeValidator dateTimeValidator = new DateTimeValidator();

    public void updateIncomeDate(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė pajamų įrašo datos reikšmė: %s\n", incomeRecord.getDate());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setDate(dateTimeValidator.enterDateTime());
                System.out.println("\nNauja pajamų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPajamų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
