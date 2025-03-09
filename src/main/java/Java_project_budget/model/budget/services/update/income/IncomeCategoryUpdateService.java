package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.input.income.IncomeCategoryInput;

public final class IncomeCategoryUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeCategoryInput incomeCategory = new IncomeCategoryInput();

    public void updateIncomeCategory(IncomeRecord incomeRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė pajamų kategorijos reikšmė: %s\n",
                incomeRecord.getCategory().getPrintLT()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setCategory(incomeCategory.enterIncomeCategory());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja pajamų kategorijos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nPajamų kategorijos reikšmė nebuvo redaguota.");
        }
    }
}
