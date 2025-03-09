package Java_project_budget.model.input.utils;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.enums.Months;

public final class DisplayMonths {

    public static void printMonths() {
        PrintMessages.printMessageWithNewLine("\nMėnesių sąrašas:");

        for (int i = 0; i < Months.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, Months.values()[i].getPrintLT()));
        }
    }
}
