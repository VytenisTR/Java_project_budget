package Java_project_budget.model.budget.services;

import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.enums.PaymentType;
import Java_project_budget.model.domain.parent.AmountInput;
import Java_project_budget.model.input.expenses.ExpensesOtherInformationInput;
import Java_project_budget.model.input.expenses.date.ExpensesDateTimeInput;
import Java_project_budget.model.input.bankcard.BankCardInput;
import Java_project_budget.model.input.expenses.ExpensesAmountInput;
import Java_project_budget.model.input.expenses.ExpensesCategoryInput;
import Java_project_budget.model.input.expenses.ExpensesPaymentTypeInput;
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
