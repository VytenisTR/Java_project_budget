package Java_project_budget.model.input.utils;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.enums.CardType;

public final class DisplayCardTypes {

    public static void printCardTypes() {
        PrintMessages.printMessageWithNewLine("\nBanko kortelių tipų sąrašas:");

        for (int i = 0; i < CardType.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, CardType.values()[i].getPrintLT()));
        }
    }
}
