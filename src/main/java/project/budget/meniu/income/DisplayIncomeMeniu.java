package project.budget.meniu.income;

import project.budget.utils.PrintMessages;

public final class DisplayIncomeMeniu {

    public static void displayMeniu() {
        PrintMessages.printMessageWithNewLine
                ("\nPasirinkite norimą operaciją, įvesdami operacijos numerį iš pateikto sąrašo:");
        PrintMessages.printMessageWithNewLine("[1] - Pridėti pajamų įrašą");
        PrintMessages.printMessageWithNewLine("[2] - Pašalinti pajamų įrašą");
        PrintMessages.printMessageWithNewLine("[3] - Redaguoti pajamų įrašą");
        PrintMessages.printMessageWithNewLine("[4] - Parodyti visus pajamų įrašus");
        PrintMessages.printMessageWithNewLine("[5] - Grįžti atgal\n");
    }
}
