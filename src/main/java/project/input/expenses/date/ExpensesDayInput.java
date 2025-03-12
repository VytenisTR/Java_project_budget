package project.input.expenses.date;

import project.budget.utils.PrintMessages;
import project.domain.interfaces.DayInput;
import project.input.utils.LeapYearResolver;
import project.input.utils.MonthByNumberResolver;
import java.util.InputMismatchException;

public final class ExpensesDayInput implements DayInput {

    public int enterDay(final int userYearInput, final int userMonthInput) {
        int day = 0;
        int monthMaxDayCount = LeapYearResolver.isLeapYear(userYearInput)
                ? MonthByNumberResolver.getMonthByNumber(userMonthInput).getDayCountLeapYear()
                : MonthByNumberResolver.getMonthByNumber(userMonthInput).getDayCountNotLeapYear();

        while(day <= 0 || day > monthMaxDayCount) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nĮveskite mėnesio dieną, kurią buvo patirtos išlaidos: ");

            try {
                day = SC.nextInt();

                if (day <= 0 || day > monthMaxDayCount)
                    PrintMessages.printMessageWithoutNewLine(String.format
                            ("\nKlaidinga įvestis! Diena yra už mėnesio dienų skaičiaus ribų!\n" +
                            "Prašome įvesti mėnesio dieną " +
                            "(skaičių nuo 1 iki %d).\n", monthMaxDayCount));
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithoutNewLine(String.format
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti mėnesio dieną " +
                        "(skaičių nuo 1 iki %d).\n", monthMaxDayCount));
                SC.nextLine();
            }
        }

        return day;
    }
}
