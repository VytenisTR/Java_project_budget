package project.input.utils.display;

import project.budget.utils.PrintMessages;
import project.enums.IncomeCategory;

public final class DisplayIncomeCategories {

    public static void printIncomeCategories() {
        PrintMessages.printMessageWithNewLine("\nPajamų kategorijų sąrašas:");

        for (int i = 0; i < IncomeCategory.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, IncomeCategory.values()[i].getPrintLT()));
        }
    }
}
