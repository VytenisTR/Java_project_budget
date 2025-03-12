package project.input.utils.display;

import project.budget.utils.PrintMessages;
import project.enums.CardType;

public final class DisplayCardTypes {

    public static void printCardTypes() {
        PrintMessages.printMessageWithNewLine("\nBanko kortelių tipų sąrašas:");

        for (int i = 0; i < CardType.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, CardType.values()[i].getPrintLT()));
        }
    }
}
