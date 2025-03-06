package Java_project_budget.model.input.bankcard;

import Java_project_budget.model.domain.data.BankCard;

public final class BankCardInput {
    private final CardNumberInput cardNumberInput = new CardNumberInput();
    private final CardTypeInput cardTypeInput = new CardTypeInput();

    public BankCard enterBankCard() {
        return new BankCard(cardNumberInput.enterCardNumber(), cardTypeInput.enterCardType());
    }
}
