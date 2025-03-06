package Java_project_budget.model.domain.data;

import Java_project_budget.model.enums.CardType;
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

    public String getCardType() {
        return cardType.getPrintLT();
    }

    @Override
    public String toString() {
        return String.format("Banko kortelės numeris: %s\n" +
                "Banko kortelės tipas: %s\n", getNumber(), getCardType());
    }
}
