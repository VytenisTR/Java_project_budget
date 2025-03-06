package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.common.OtherInformationInput;

public final class ExpensesOtherInformationUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final OtherInformationInput otherInformationInput = new OtherInformationInput();

    public void updateExpensesOtherInformation(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė papildomos informacijos įrašo reikšmė: %s\n",
                expensesRecord.getOtherInformation());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setOtherInformation(otherInformationInput.enterOtherInformation());
                System.out.println("\nNauja papildomos informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPapildomos informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
