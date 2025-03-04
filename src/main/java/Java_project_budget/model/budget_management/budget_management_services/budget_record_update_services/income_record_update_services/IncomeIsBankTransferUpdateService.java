package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeIsBankTransferValidator;

public final class IncomeIsBankTransferUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeIsBankTransferValidator incomeIsBankTransferValidator = new IncomeIsBankTransferValidator();

    public void updateIncomeIsBankTransfer(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė įrašo ar pajamos buvo gautos į banko sąskaitą reikšmė: %s\n",
                incomeRecord.getIsBankTransfer());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setIsBankTransfer(incomeIsBankTransferValidator.isBankTransfer());
                System.out.println("\nNauja įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nĮrašo reikšmė nebuvo redaguota.");
        }
    }
}
