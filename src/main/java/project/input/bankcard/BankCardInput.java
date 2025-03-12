package project.input.bankcard;

import project.domain.data.BankCard;

public final class BankCardInput {
    private final CardNumberInput cardNumberInput = new CardNumberInput();
    private final CardTypeInput cardTypeInput = new CardTypeInput();

    public BankCard enterBankCard() {
        return new BankCard(cardNumberInput.enterCardNumber(), cardTypeInput.enterCardType());
    }
}
