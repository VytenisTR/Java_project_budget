package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeCategoryValidator;

public final class IncomeCategoryUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeCategoryValidator incomeCategoryValidator = new IncomeCategoryValidator();

    public void updateIncomeCategory(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė pajamų kategorijos reikšmė: %s\n", incomeRecord.getCategory());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setCategory(incomeCategoryValidator.enterIncomeCategory());
                System.out.println("\nNauja pajamų kategorijos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPajamų kategorijos reikšmė nebuvo redaguota.");
        }
    }
}
