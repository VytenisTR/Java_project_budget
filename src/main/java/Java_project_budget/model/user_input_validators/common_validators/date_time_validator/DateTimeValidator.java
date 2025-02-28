package Java_project_budget.model.user_input_validators.common_validators.date_time_validator;

import java.time.LocalDateTime;

public final class DateTimeValidator {

    public LocalDateTime enterDateTime() {
        final int userYearInput = new YearValidator().enterYear();
        final int userMonthInput = new MonthValidator().enterMonth();
        final int userDayInput = new DayValidator().enterDay(userYearInput, userMonthInput);

        return LocalDateTime.of(userYearInput, userMonthInput, userDayInput, 0, 0);
    }
}
