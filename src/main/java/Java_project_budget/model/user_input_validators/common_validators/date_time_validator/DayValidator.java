package Java_project_budget.model.user_input_validators.common_validators.date_time_validator;

import Java_project_budget.model.user_input_validators.validator_utilities.CheckLeapYear;
import Java_project_budget.model.user_input_validators.validator_utilities.GetMonthByNumber;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class DayValidator {
    private static final Scanner SC = new Scanner(System.in);

    public int enterDay(final int userYearInput, final int userMonthInput) {
        int day = 0;
        int monthMaxDayCount = CheckLeapYear.isLeapYear(userYearInput)
                ? GetMonthByNumber.getMonth(userMonthInput).getDayCountLeapYear()
                : GetMonthByNumber.getMonth(userMonthInput).getDayCountNotLeapYear();

        while(day <= 0 || day > monthMaxDayCount) {
            System.out.print("\nĮveskite mėnesio dieną, kurią buvo gautos pajamos: ");

            try {
                day = SC.nextInt();

                if (day <= 0 || day > monthMaxDayCount)
                    System.out.printf("\nKlaidinga įvestis! Diena yra už mėnesio dienų skaičiaus ribų!\n" +
                            "Prašome įvesti mėnesio dieną " +
                            "(skaičių nuo 1 iki %d).\n", monthMaxDayCount);
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.printf("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti mėnesio dieną " +
                        "(skaičių nuo 1 iki %d).\n", monthMaxDayCount);
                SC.nextLine();
            }
        }

        return day;
    }
}
