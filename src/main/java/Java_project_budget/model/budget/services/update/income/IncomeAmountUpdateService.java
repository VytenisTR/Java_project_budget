package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.input.income.IncomeAmountInput;

public final class IncomeAmountUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeAmountInput incomeAmountInput = new IncomeAmountInput();

    public void updateIncomeAmount(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė pajamų sumos reikšmė: %.2f\n", incomeRecord.getAmount());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setAmount(incomeAmountInput.enterAmount());
                System.out.println("\nNauja pajamų sumos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPajamų sumos reikšmė nebuvo redaguota.");
        }
    }
}
