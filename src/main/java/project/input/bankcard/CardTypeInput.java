package project.input.bankcard;

import project.budget.utils.PrintMessages;
import project.domain.interfaces.ScannerInput;
import project.enums.CardType;
import project.input.utils.display.DisplayCardTypes;
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
