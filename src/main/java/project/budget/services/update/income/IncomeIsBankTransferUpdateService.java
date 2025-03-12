package project.budget.services.update.income;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.input.income.IncomeIsBankTransferInput;

public final class IncomeIsBankTransferUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeIsBankTransferInput incomeIsBankTransferInput = new IncomeIsBankTransferInput();

    public void updateIncomeIsBankTransfer(IncomeRecord incomeRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė įrašo ar pajamos buvo gautos į banko sąskaitą reikšmė: %s\n",
                incomeRecord.getIsBankTransfer()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setIsBankTransfer(incomeIsBankTransferInput.isBankTransfer());
                PrintMessages.printMessageWithNewLine("\nNauja įrašo reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine("\nĮrašo reikšmė nebuvo redaguota.");
        }
    }
}
