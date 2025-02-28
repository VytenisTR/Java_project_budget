package Java_project_budget.model.data_classes_resolvers;

import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.enums.PaymentType;
import Java_project_budget.model.user_input_validators.common_validators.OtherInformationValidator;
import Java_project_budget.model.user_input_validators.common_validators.date_time_validator.DateTimeValidator;
import Java_project_budget.model.user_input_validators.expenses_record_validators.ExpensesAmountValidator;
import Java_project_budget.model.user_input_validators.expenses_record_validators.ExpensesCategoryValidator;
import Java_project_budget.model.user_input_validators.expenses_record_validators.PaymentTypeValidator;
import Java_project_budget.model.user_input_validators.expenses_record_validators.bank_card_validator.BankCardValidator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class ExpensesRecordResolver {
    private final ExpensesAmountValidator expensesAmountValidator = new ExpensesAmountValidator();
    private final ExpensesCategoryValidator expensesCategoryValidator = new ExpensesCategoryValidator();
    private final DateTimeValidator dateTimeValidator = new DateTimeValidator();
    private final PaymentTypeValidator paymentTypeValidator = new PaymentTypeValidator();
    private final BankCardValidator bankCardValidator = new BankCardValidator();
    private final OtherInformationValidator otherInformationValidator = new OtherInformationValidator();

    public ExpensesRecord createExpensesRecord() {
        final BigDecimal expensesAmount = expensesAmountValidator.enterAmount();
        final ExpensesCategory expensesCategory = expensesCategoryValidator.enterExpensesCategory();
        final LocalDateTime localDateTime = dateTimeValidator.enterDateTime();
        final PaymentType paymentType = paymentTypeValidator.enterPaymentType();

        if (paymentType.getPrintLT().equals("Grynieji"))
            return new ExpensesRecord(expensesAmount,
                    expensesCategory,
                    localDateTime, paymentType,
                    otherInformationValidator.enterOtherInformation());
        else
            return new ExpensesRecord(expensesAmount,
                    expensesCategory,
                    localDateTime, paymentType,
                    bankCardValidator.enterBankCard(), otherInformationValidator.enterOtherInformation());
    }
}
