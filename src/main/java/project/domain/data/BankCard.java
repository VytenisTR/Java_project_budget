package project.domain.data;

import project.enums.CardType;
import java.io.Serializable;

public final class BankCard implements Serializable {
    private final String number;
    private final CardType cardType;

    public BankCard(final String number, final CardType cardType) {
        this.number = number;
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return String.format("Banko kortelės numeris: %s\n" +
                "Banko kortelės tipas: %s\n", getNumber(), getCardType().getPrintLT());
    }
}
