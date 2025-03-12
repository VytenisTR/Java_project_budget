package project.budget.services;

import project.domain.data.ExpensesRecord;
import project.enums.ExpensesCategory;
import project.enums.PaymentType;
import project.domain.interfaces.AmountInput;
import project.input.expenses.ExpensesOtherInformationInput;
import project.input.expenses.date.ExpensesDateTimeInput;
import project.input.bankcard.BankCardInput;
import project.input.expenses.ExpensesAmountInput;
import project.input.expenses.ExpensesCategoryInput;
import project.input.expenses.ExpensesPaymentTypeInput;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class ExpensesRecordResolverService {
    private final AmountInput amountInput = new ExpensesAmountInput();
    private final ExpensesCategoryInput expensesCategoryInput = new ExpensesCategoryInput();
    private final ExpensesDateTimeInput expensesDateTimeInput = new ExpensesDateTimeInput();
    private final ExpensesPaymentTypeInput expensesPaymentTypeInput = new ExpensesPaymentTypeInput();
    private final BankCardInput bankCardInput = new BankCardInput();
    private final ExpensesOtherInformationInput expensesOtherInformationInput = new ExpensesOtherInformationInput();

    public ExpensesRecord createExpensesRecord() {
        final BigDecimal expensesAmount = amountInput.enterAmount();
        final ExpensesCategory expensesCategory = expensesCategoryInput.enterExpensesCategory();
        final LocalDateTime localDateTime = expensesDateTimeInput.enterDateTime();
        final PaymentType paymentType = expensesPaymentTypeInput.enterPaymentType();

        if (paymentType == PaymentType.GRYNIEJI)
            return new ExpensesRecord(expensesAmount,
                    expensesCategory,
                    localDateTime, paymentType,
                    expensesOtherInformationInput.enterOtherInformation());
        else
            return new ExpensesRecord(expensesAmount,
                    expensesCategory,
                    localDateTime, paymentType,
                    bankCardInput.enterBankCard(), expensesOtherInformationInput.enterOtherInformation());
    }
}
