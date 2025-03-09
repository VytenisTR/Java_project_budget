package Java_project_budget.model.input.income.date;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.input.utils.LeapYearResolver;
import Java_project_budget.model.input.utils.MonthByNumberResolver;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class IncomeDayInput {
    private static final Scanner SC = new Scanner(System.in);

    public int enterDay(final int userYearInput, final int userMonthInput) {
        int day = 0;
        int monthMaxDayCount = LeapYearResolver.isLeapYear(userYearInput)
                ? MonthByNumberResolver.getMonthByNumber(userMonthInput).getDayCountLeapYear()
                : MonthByNumberResolver.getMonthByNumber(userMonthInput).getDayCountNotLeapYear();

        while(day <= 0 || day > monthMaxDayCount) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nĮveskite mėnesio dieną, kurią buvo gautos pajamos: ");

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
