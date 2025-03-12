package project.input.expenses.date;

import project.budget.utils.PrintMessages;
import project.domain.interfaces.MonthInput;
import project.input.utils.display.DisplayMonths;
import java.util.InputMismatchException;

public final class ExpensesMonthInput implements MonthInput {

    public int enterMonth() {
        int month = 0;

        while(month <= 0) {
            DisplayMonths.printMonths();

            PrintMessages.printMessageWithoutNewLine
                    ("\nNurodykite metų mėnesį, kurį buvo patirtos išlaidos, įvesdami mėnesio numerį: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> month = 1;
                    case 2 -> month = 2;
                    case 3 -> month = 3;
                    case 4 -> month = 4;
                    case 5 -> month = 5;
                    case 6 -> month = 6;
                    case 7 -> month = 7;
                    case 8 -> month = 8;
                    case 9 -> month = 9;
                    case 10 -> month = 10;
                    case 11 -> month = 11;
                    case 12 -> month = 12;
                    default -> month = 0;
                }

                if (month == 0)
                    PrintMessages.printMessageWithNewLine
                            ("\nKlaidinga įvestis! Toks mėnesio numeris neegzistuoja!\n" +
                            "Prašome nurodyti metų mėnesį, " +
                            "įvedant mėnesio numerį (skaičių nuo 1 iki 12).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti metų mėnesį, " +
                        "įvedant mėnesio numerį (skaičių nuo 1 iki 12).");
                SC.nextLine();
            }
        }

        return month;
    }
}
