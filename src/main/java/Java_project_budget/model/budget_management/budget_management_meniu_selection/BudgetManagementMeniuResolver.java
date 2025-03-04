package Java_project_budget.model.budget_management.budget_management_meniu_selection;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class BudgetManagementMeniuResolver {
    private static final Scanner SC = new Scanner(System.in);

    public int resolveMeniu() {
        int userInput = 0;

        while (userInput < 1 || userInput > 10) {
            DisplayBudgetManagementMeniu.displayMeniu();

            System.out.print("Įveskite operacijos numerį: ");

            try {
                userInput = SC.nextInt();

                if (userInput < 1 || userInput > 10)
                    System.out.println("\nKlaidingas operacijos numeris! " +
                            "Prašome įvesti pageidaujamos atlikti operacijos " +
                            "numerį (skaičių nuo 1 iki 10).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu! " +
                        "Prašome įvesti pageidaujamos atlikti operacijos " +
                        "numerį (skaičių nuo 1 iki 10).\n");
                SC.nextLine();
            }
        }

        return userInput;
    }
}
