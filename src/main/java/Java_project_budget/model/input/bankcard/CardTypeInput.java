package Java_project_budget.model.input.bankcard;

import Java_project_budget.model.enums.CardType;
import Java_project_budget.model.input.utils.DisplayCardTypes;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class CardTypeInput {
    private static final Scanner SC = new Scanner(System.in);

    public CardType enterCardType() {
        CardType cardType = null;

        while(cardType == null) {
            DisplayCardTypes.printCardTypes();

            System.out.print("\nPasirinkite banko kortelės tipą, " +
                    "įvesdami jo numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> cardType = CardType.KREDITINĖ;
                    case 2 -> cardType = CardType.DEBETINĖ;
                    default -> cardType = null;
                }

                if (cardType == null)
                    System.out.println("\nKlaidinga įvestis! Toks banko kortelės tipas neegzistuoja!\n" +
                            "Prašome įvesti banko kortelės tipo " +
                            "numerį iš pateikto sąrašo (skaičių 1 arba 2).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti banko kortelės tipo " +
                        "numerį iš pateikto sąrašo (skaičių 1 arba 2).");
                SC.nextLine();
            }
        }

        return cardType;
    }
}
