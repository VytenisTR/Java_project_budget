package project.budget.services.update.income;

import project.budget.meniu.update.RecordUpdateMeniuResolver;
import project.budget.utils.PrintMessages;
import project.domain.data.IncomeRecord;
import project.input.income.date.IncomeDateTimeInput;

public final class IncomeDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final IncomeDateTimeInput incomeDateTimeInput = new IncomeDateTimeInput();

    public void updateIncomeDate(IncomeRecord incomeRecord) {
        PrintMessages.printMessageWithoutNewLine(
                String.format("\nDabartinė pajamų įrašo datos reikšmė: %s\n",
                incomeRecord.getDate()));

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setDate(incomeDateTimeInput.enterDateTime());
                PrintMessages.printMessageWithNewLine
                        ("\nNauja pajamų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> PrintMessages.printMessageWithNewLine
                    ("\nPajamų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
