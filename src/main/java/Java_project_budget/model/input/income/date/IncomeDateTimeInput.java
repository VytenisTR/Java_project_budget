package Java_project_budget.model.input.income.date;

import java.time.LocalDateTime;

public final class IncomeDateTimeInput {

    public LocalDateTime enterDateTime() {
        final int userYearInput = new IncomeYearInput().enterYear();
        final int userMonthInput = new IncomeMonthInput().enterMonth();
        final int userDayInput = new IncomeDayInput().enterDay(userYearInput, userMonthInput);

        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
