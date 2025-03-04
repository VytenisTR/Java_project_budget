package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.budget_management.budget_management_meniu_selection.RecordUpdateMeniuResolver;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.common_validators.OtherInformationValidator;

public final class IncomeOtherInformationUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final OtherInformationValidator otherInformationValidator = new OtherInformationValidator();

    public void updateIncomeOtherInformation(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė papildomos informacijos įrašo reikšmė: %s\n",
                incomeRecord.getOtherInformation());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setOtherInformation(otherInformationValidator.enterOtherInformation());
                System.out.println("\nNauja papildomos informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPapildomos informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
