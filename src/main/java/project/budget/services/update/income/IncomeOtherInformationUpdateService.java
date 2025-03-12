package project.budget.services.update.income;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.input.income.IncomeOtherInformationInput;

public final class IncomeOtherInformationUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeOtherInformationInput incomeOtherInformationInput = new IncomeOtherInformationInput();

    public void updateIncomeOtherInformation(IncomeRecord incomeRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė papildomos informacijos įrašo reikšmė: %s\n",
                incomeRecord.getOtherInformation()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setOtherInformation(incomeOtherInformationInput.enterOtherInformation());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja papildomos informacijos įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nPapildomos informacijos įrašo reikšmė nebuvo redaguota.");
        }
    }
}
