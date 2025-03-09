package Java_project_budget.model.budget.meniu.update;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.ScannerInput;
import java.util.InputMismatchException;

public final class RecordUpdateMeniuResolver implements ScannerInput {

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 2) {
            DisplayRecordUpdateMeniu.displayMeniu();

            PrintMessages.printMessageWithoutNewLine("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 2)
                    PrintMessages.printMessageWithNewLine("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių 1 arba 2).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių 1 arba 2).\n");
                SC.nextLine();
            }
        }

        return userInput;
    }
}
