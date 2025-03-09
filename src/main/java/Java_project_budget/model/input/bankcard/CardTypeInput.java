package Java_project_budget.model.input.bankcard;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.ScannerInput;
import Java_project_budget.model.enums.CardType;
import Java_project_budget.model.input.utils.DisplayCardTypes;
import java.util.InputMismatchException;

public final class CardTypeInput implements ScannerInput {

    public CardType enterCardType() {
        CardType cardType = null;

        while(cardType == null) {
            DisplayCardTypes.printCardTypes();

            PrintMessages.printMessageWithoutNewLine("\nPasirinkite banko kortelės tipą, " +
                    "įvesdami jo numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> cardType = CardType.KREDITINE;
                    case 2 -> cardType = CardType.DEBETINE;
                    default -> cardType = null;
                }

                if (cardType == null)
                    PrintMessages.printMessageWithNewLine
                            ("\nKlaidinga įvestis! Toks banko kortelės tipas neegzistuoja!\n" +
                            "Prašome įvesti banko kortelės tipo " +
                            "numerį iš pateikto sąrašo (skaičių 1 arba 2).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti banko kortelės tipo " +
                        "numerį iš pateikto sąrašo (skaičių 1 arba 2).");
                SC.nextLine();
            }
        }

        return cardType;
    }
}
