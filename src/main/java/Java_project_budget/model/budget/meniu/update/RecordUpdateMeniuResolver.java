package Java_project_budget.model.budget.meniu.update;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class RecordUpdateMeniuResolver {
    private static final Scanner SC = new Scanner(System.in);

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 2) {
            DisplayRecordUpdateMeniu.displayMeniu();

            System.out.print("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 2)
                    System.out.println("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių 1 arba 2).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių 1 arba 2).\n");
                SC.nextLine();
            }
        }

        return userInput;
    }
}
