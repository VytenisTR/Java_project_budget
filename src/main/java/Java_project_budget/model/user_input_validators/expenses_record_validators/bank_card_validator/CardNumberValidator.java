package Java_project_budget.model.user_input_validators.expenses_record_validators.bank_card_validator;

import java.util.Scanner;

public final class CardNumberValidator {
    private static final Scanner SC = new Scanner(System.in);

    public String enterCardNumber() {
        String cardNumber = null;

        while (cardNumber == null) {
            System.out.print("\nĮveskite banko kortelės numerį, susidedantį iš 20 ženklų: ");

            String userInput = SC.next();

            if(userInput.isBlank()) {
                System.out.println("\nKortelės numeris negali būti tuščias!");
            }
            else if (userInput.length() < 20) {
                System.out.println("\nKortelės numeris negali būti mažesnis negu 20 ženklų!");
            }
            else if (userInput.length() > 20) {
                System.out.println("\nKortelės numeris negali būti didesnis negu 20 ženklų!");
            }
            else {
                cardNumber = userInput.toUpperCase();
                cardNumber = cardNumber.substring(0, 4).concat("-")
                        + cardNumber.substring(4, 8).concat("-")
                        + cardNumber.substring(8, 12).concat("-")
                        + cardNumber.substring(12, 16).concat("-")
                        + cardNumber.substring(16).concat("-");
            }
        }

        return cardNumber;
    }
}
