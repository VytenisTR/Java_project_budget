package Java_project_budget.model.budget.meniu.budget;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.ScannerInput;
import java.util.InputMismatchException;

public final class BudgetMeniuResolver implements ScannerInput {

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 5) {
            DisplayBudgetMeniu.displayMeniu();

            PrintMessages.printMessageWithoutNewLine("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 5)
                    PrintMessages.printMessageWithNewLine("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių nuo 1 iki 5).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių nuo 1 iki 5).\n");
                SC.nextLine();
            }
        }

        return userInput;
    }
}
