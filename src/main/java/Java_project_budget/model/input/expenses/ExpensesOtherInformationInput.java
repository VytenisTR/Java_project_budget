package Java_project_budget.model.input.expenses;

import Java_project_budget.model.budget.utils.PrintMessages;
import java.util.Scanner;

public final class ExpensesOtherInformationInput {
    private static final Scanner SC = new Scanner(System.in);

    public String enterOtherInformation() {
        String otherInformation = null;

        while(otherInformation == null) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nĮveskite papildomą informaciją apie patirtas išlaidas: ");

            String userInput = SC.next();

            if (userInput.isBlank()) {
                otherInformation = "";
            } else {
                otherInformation = (userInput.substring(0, 1).toUpperCase()
                        + userInput.substring(1).toLowerCase()).trim();
            }
        }

        return otherInformation;
    }
}
