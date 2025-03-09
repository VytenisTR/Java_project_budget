package Java_project_budget.model.input.bankcard;

import Java_project_budget.model.budget.utils.PrintMessages;
import java.util.Scanner;

public final class CardNumberInput {
    private static final Scanner SC = new Scanner(System.in);

    public String enterCardNumber() {
        String cardNumber = null;

        while (cardNumber == null) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nĮveskite banko kortelės numerį, susidedantį iš 20 ženklų: ");

            String userInput = SC.next();

            if(userInput.isBlank()) {
                PrintMessages.printMessageWithNewLine("\nKortelės numeris negali būti tuščias!");
            }
            else if (userInput.length() < 20) {
                PrintMessages.printMessageWithNewLine
                        ("\nKortelės numeris negali būti mažesnis negu 20 ženklų!");
            }
            else if (userInput.length() > 20) {
                PrintMessages.printMessageWithNewLine
                        ("\nKortelės numeris negali būti didesnis negu 20 ženklų!");
            }
            else {
                cardNumber = (userInput.substring(0, 4).concat("-")
                        + userInput.substring(4, 8).concat("-")
                        + userInput.substring(8, 12).concat("-")
                        + userInput.substring(12, 16).concat("-")
                        + userInput.substring(16)).toUpperCase();
            }
        }

        return cardNumber;
    }
}
