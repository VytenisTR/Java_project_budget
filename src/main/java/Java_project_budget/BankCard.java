package Java_project_budget;

import Java_project_budget.BudgetEnums.CardType;

public class BankCard {
    private final String number;
    private final CardType cardType;

    public BankCard(final String number, final CardType cardType) {
        this.number = number.toUpperCase().trim();
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public String getCardType() {
        return (cardType.toString().substring(0, 1).toUpperCase() +
                cardType.toString().substring(1).toLowerCase())
                .replace('_', ' ');
    }

    @Override
    public String toString() {
        return String.format("Banko kortelės numeris: %s\n" +
                "Banko kortelės tipas: %s\n", getNumber(), getCardType());
    }
}
