package Java_project_budget.model.budget.meniu.budget;

import Java_project_budget.model.budget.utils.PrintMessages;

public final class DisplayBudgetMeniu {

    public static void displayMeniu() {
        PrintMessages.printMessageWithNewLine
                ("\nPasirinkite norimą operaciją, įvesdami operacijos numerį iš pateikto sąrašo:");
        PrintMessages.printMessageWithNewLine("[1] - Biudžeto pajamų įrašų meniu");
        PrintMessages.printMessageWithNewLine("[2] - Biudžeto išlaidų įrašų meniu");
        PrintMessages.printMessageWithNewLine("[3] - Biudžeto įrašų importo / eksporto meniu");
        PrintMessages.printMessageWithNewLine("[4] - Patikrinti balansą");
        PrintMessages.printMessageWithNewLine("[5] - Išjungti programą\n");
    }
}
