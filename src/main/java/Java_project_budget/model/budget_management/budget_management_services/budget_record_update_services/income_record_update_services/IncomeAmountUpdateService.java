package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeAmountValidator;

public final class IncomeAmountUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeAmountValidator incomeAmountValidator = new IncomeAmountValidator();

    public void updateIncomeAmount(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė pajamų sumos reikšmė: %.2f\n", incomeRecord.getAmount());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setAmount(incomeAmountValidator.enterAmount());
                System.out.println("\nNauja pajamų sumos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPajamų sumos reikšmė nebuvo redaguota.");
        }
    }
}
