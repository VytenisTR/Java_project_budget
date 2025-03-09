package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.input.income.IncomeAmountInput;

public final class IncomeAmountUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeAmountInput incomeAmountInput = new IncomeAmountInput();

    public void updateIncomeAmount(IncomeRecord incomeRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė pajamų sumos reikšmė: %.2f\n", incomeRecord.getAmount()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setAmount(incomeAmountInput.enterAmount());
                PrintMessages.printMessageWithNewLine("\nNauja pajamų sumos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine("\nPajamų sumos reikšmė nebuvo redaguota.");
        }
    }
}
