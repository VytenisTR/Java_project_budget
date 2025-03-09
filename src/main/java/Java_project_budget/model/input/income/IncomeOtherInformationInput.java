package Java_project_budget.model.input.income;

import Java_project_budget.model.budget.utils.PrintMessages;
import java.util.Scanner;

public final class IncomeOtherInformationInput {
    private static final Scanner SC = new Scanner(System.in);

    public String enterOtherInformation() {
        String otherInformation = null;

        while(otherInformation == null) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nĮveskite papildomą informaciją apie gautas pajamas: ");

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
