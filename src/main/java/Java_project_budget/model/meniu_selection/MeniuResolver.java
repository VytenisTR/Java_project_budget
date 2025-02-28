package Java_project_budget.model.meniu_selection;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MeniuResolver {
    private final Scanner SC = new Scanner(System.in);
    private final MeniuSelect meniuSelect = new MeniuSelect();

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 6) {
            meniuSelect.displayMeniu();

            System.out.print("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 6)
                    System.out.println("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių nuo 1 iki 6).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių nuo 1 iki 6).\n");
            }
        }

        SC.close();

        return userInput;
    }
}
