package project.input.utils.display;

import project.budget.utils.PrintMessages;
import project.enums.Months;

public final class DisplayMonths {

    public static void printMonths() {
        PrintMessages.printMessageWithNewLine("\nMėnesių sąrašas:");

        for (int i = 0; i < Months.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, Months.values()[i].getPrintLT()));
        }
    }
}
