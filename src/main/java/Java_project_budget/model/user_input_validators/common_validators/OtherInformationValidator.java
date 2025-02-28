package Java_project_budget.model.user_input_validators.common_validators;

import java.util.Scanner;

public final class OtherInformationValidator {
    private static final Scanner SC = new Scanner(System.in);

    public String enterOtherInformation() {
        String otherInformation = null;

        while(otherInformation == null) {
            System.out.print("\nĮveskite papildomą informaciją apie gautas pajamas: ");

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
