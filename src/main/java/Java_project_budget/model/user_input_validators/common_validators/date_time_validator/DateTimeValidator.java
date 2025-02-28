package Java_project_budget.model.user_input_validators.common_validators.date_time_validator;

import java.time.LocalDateTime;

public final class DateTimeValidator {
    private final int userYearInput = new YearValidator().enterYear();
    private final int userMonthInput = new MonthValidator().enterMonth();
    private final int userDayInput = new DayValidator().enterDay(userYearInput, userMonthInput);

    public LocalDateTime enterDateTime() {
        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
