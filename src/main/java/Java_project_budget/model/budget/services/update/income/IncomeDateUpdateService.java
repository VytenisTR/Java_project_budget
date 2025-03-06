package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.input.common.date.DateTimeInput;

public final class IncomeDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final DateTimeInput dateTimeInput = new DateTimeInput();

    public void updateIncomeDate(IncomeRecord incomeRecord) {
        System.out.printf("\nDabartinė pajamų įrašo datos reikšmė: %s\n", incomeRecord.getDate());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                incomeRecord.setDate(dateTimeInput.enterDateTime());
                System.out.println("\nNauja pajamų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nPajamų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
