package Java_project_budget.model.input.common.date;

import java.time.LocalDateTime;

public final class DateTimeInput {

    public LocalDateTime enterDateTime() {
        final int userYearInput = new YearInput().enterYear();
        final int userMonthInput = new MonthInput().enterMonth();
        final int userDayInput = new DayInput().enterDay(userYearInput, userMonthInput);

        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
