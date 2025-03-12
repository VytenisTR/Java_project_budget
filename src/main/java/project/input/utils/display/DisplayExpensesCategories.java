package project.input.utils.display;

import project.budget.utils.PrintMessages;
import project.enums.ExpensesCategory;

public final class DisplayExpensesCategories {

    public static void printExpensesCategories() {
        PrintMessages.printMessageWithNewLine("\nIšlaidų kategorijų sąrašas:");

        for (int i = 0; i < ExpensesCategory.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, ExpensesCategory.values()[i].getPrintLT()));
        }
    }
}
