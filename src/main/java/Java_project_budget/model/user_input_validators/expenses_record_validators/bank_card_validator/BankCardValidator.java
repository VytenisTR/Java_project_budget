package Java_project_budget.model.user_input_validators.expenses_record_validators.bank_card_validator;

import Java_project_budget.model.data_classes.BankCard;

public final class BankCardValidator {
    private final CardNumberValidator cardNumberValidator = new CardNumberValidator();
    private final CardTypeValidator cardTypeValidator = new CardTypeValidator();

    public BankCard enterBankCard() {
        return new BankCard(cardNumberValidator.enterCardNumber(), cardTypeValidator.enterCardType());
    }
}
