package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.input.common.OtherInformationInput;

public final class IncomeOtherInformationUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final OtherInformationInput otherInformationInput = new OtherInformationInput();

    public void updateIncomeOtherInformation(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė papildomos informacijos įrašo reikšmė: %s\n",
                incomeRecord.getOtherInformation());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setOtherInformation(otherInformationInput.enterOtherInformation());
                System.out.println("\nNauja papildomos informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPapildomos informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
