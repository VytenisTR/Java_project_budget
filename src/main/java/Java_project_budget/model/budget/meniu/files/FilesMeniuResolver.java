package Java_project_budget.model.budget.meniu.files;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class FilesMeniuResolver {
    private static final Scanner SC = new Scanner(System.in);

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 7) {
            DisplayFilesMeniu.displayMeniu();

            System.out.print("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 7)
                    System.out.println("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių nuo 1 iki 7).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių nuo 1 iki 7).\n");
                SC.nextLine();
            }
        }

        return userInput;
    }
}
