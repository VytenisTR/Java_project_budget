package Java_project_budget.model.budget.meniu.expenses;

import Java_project_budget.model.budget.utils.PrintMessages;

public final class DisplayExpensesMeniu {

    public static void displayMeniu() {
        PrintMessages.printMessageWithNewLine
                ("\nPasirinkite norimą operaciją, įvesdami operacijos numerį iš pateikto sąrašo:");
        PrintMessages.printMessageWithNewLine("[1] - Pridėti išlaidų įrašą");
        PrintMessages.printMessageWithNewLine("[2] - Pašalinti išlaidų įrašą");
        PrintMessages.printMessageWithNewLine("[3] - Redaguoti išlaidų įrašą");
        PrintMessages.printMessageWithNewLine("[4] - Parodyti visus išlaidų įrašus");
        PrintMessages.printMessageWithNewLine("[5] - Grįžti atgal\n");
    }
}
