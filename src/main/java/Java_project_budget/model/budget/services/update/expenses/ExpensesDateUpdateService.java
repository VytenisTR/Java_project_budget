package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.common.date.DateTimeInput;

public final class ExpensesDateUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final DateTimeInput dateTimeInput = new DateTimeInput();

    public void updateExpensesDate(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė išlaidų įrašo datos reikšmė: %s\n", expensesRecord.getDate());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setDate(dateTimeInput.enterDateTime());
                System.out.println("\nNauja išlaidų įrašo datos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nIšlaidų įrašo datos reikšmė nebuvo redaguota.");
        }
    }
}
