package Java_project_budget.model.input.expenses.date;

import Java_project_budget.model.domain.interfaces.DateTimeInput;
import java.time.LocalDateTime;

public final class ExpensesDateTimeInput implements DateTimeInput {

    public LocalDateTime enterDateTime() {
        final int userYearInput = new ExpensesYearInput().enterYear();
        final int userMonthInput = new ExpensesMonthInput().enterMonth();
        final int userDayInput = new ExpensesDayInput().enterDay(userYearInput, userMonthInput);

        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
