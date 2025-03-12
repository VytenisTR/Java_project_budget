package project.budget.services.files.transformers;

import project.domain.data.BankCard;
import project.domain.data.ExpensesRecord;
import project.enums.CardType;
import project.enums.ExpensesCategory;
import project.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class ExpensesCSVReadTransformer {

    public ExpensesRecord transformFromCSV(String[] budgetRecordStrings) {
        try {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            final BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(budgetRecordStrings[1].
                    concat(".").concat(budgetRecordStrings[2])));
            final ExpensesCategory category = ExpensesCategory.valueOf(budgetRecordStrings[3]);
            final LocalDateTime date = LocalDateTime.parse(budgetRecordStrings[4], dateTimeFormatter);
            final PaymentType paymentType = PaymentType.valueOf(budgetRecordStrings[5]);
            final String otherInformation = budgetRecordStrings[8];

            if (paymentType == PaymentType.GRYNIEJI) {
                return new ExpensesRecord(amount, category, date, paymentType, otherInformation);
            } else {
                return new ExpensesRecord(amount, category, date, paymentType,
                        new BankCard(budgetRecordStrings[6],
                                CardType.valueOf(budgetRecordStrings[7])),
                        otherInformation);
            }
        } catch (NullPointerException | IllegalArgumentException | DateTimeParseException exception) {
            return null;
        }
    }
}
