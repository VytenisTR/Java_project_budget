package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.budget.meniu.update.RecordUpdateMeniuResolver;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.input.expenses.ExpensesCategoryInput;

public final class ExpensesCategoryUpdateService {
    private final RecordUpdateMeniuResolver recordUpdateMeniuResolver = new RecordUpdateMeniuResolver();
    private final ExpensesCategoryInput expensesCategoryInput = new ExpensesCategoryInput();

    public void updateExpensesCategory(ExpensesRecord expensesRecord) {
        System.out.printf("\nDabartinė išlaidų kategorijos reikšmė: %s\n", expensesRecord.getCategory());

        switch (recordUpdateMeniuResolver.resolveMeniu()) {
            case 1 -> {
                expensesRecord.setCategory(expensesCategoryInput.enterExpensesCategory());
                System.out.println("\nNauja išlaidų kategorijos reikšmė išsaugota.");
            }
            case 2 -> System.out.println("\nIšlaidų kategorijos reikšmė nebuvo redaguota.");
        }
    }
}
