package Java_project_budget.model.input.income.date;

import Java_project_budget.model.domain.interfaces.DateTimeInput;
import java.time.LocalDateTime;

public final class IncomeDateTimeInput implements DateTimeInput {

    public LocalDateTime enterDateTime() {
        final int userYearInput = new IncomeYearInput().enterYear();
        final int userMonthInput = new IncomeMonthInput().enterMonth();
        final int userDayInput = new IncomeDayInput().enterDay(userYearInput, userMonthInput);

        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
