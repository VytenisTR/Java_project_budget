package Java_project_budget.model.data_classes;

import Java_project_budget.model.enums.CardType;

public final class BankCard {
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
