package project.budget.meniu.files;

import project.budget.utils.PrintMessages;

public final class DisplayFilesMeniu {

    public static void displayMeniu() {
        PrintMessages.printMessageWithNewLine
                ("\nPasirinkite norimą operaciją, įvesdami operacijos numerį iš pateikto sąrašo:");
        PrintMessages.printMessageWithNewLine("[1] - Išsaugoti biudžeto pajamų įrašus į CSV");
        PrintMessages.printMessageWithNewLine("[2] - Išsaugoti biudžeto išlaidų įrašus į CSV");
        PrintMessages.printMessageWithNewLine("[3] - Išsaugoti biudžeto pajamų ir išlaidų įrašus į CSV");
        PrintMessages.printMessageWithNewLine("[4] - Gauti biudžeto pajamų įrašus iš CSV");
        PrintMessages.printMessageWithNewLine("[5] - Gauti biudžeto išlaidų įrašus iš CSV");
        PrintMessages.printMessageWithNewLine("[6] - Gauti biudžeto pajamų ir išlaidų įrašus iš CSV");
        PrintMessages.printMessageWithNewLine("[7] - Grįžti atgal\n");
    }
}
