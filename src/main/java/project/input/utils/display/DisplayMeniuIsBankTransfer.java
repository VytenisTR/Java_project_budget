package project.input.utils.display;

import project.budget.utils.PrintMessages;

public final class DisplayMeniuIsBankTransfer {

    public static void displayMeniu() {
        PrintMessages.printMessageWithNewLine("\nAr pajamos buvo gautos į banko sąskaitą:");
        PrintMessages.printMessageWithNewLine("[1] - Taip");
        PrintMessages.printMessageWithNewLine("[2] - Ne");
    }
}
