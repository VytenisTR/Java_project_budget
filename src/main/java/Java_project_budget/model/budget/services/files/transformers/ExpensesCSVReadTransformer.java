package Java_project_budget.model.budget.services.files.transformers;

import Java_project_budget.model.domain.data.BankCard;
import Java_project_budget.model.domain.data.ExpensesRecord;
import Java_project_budget.model.enums.CardType;
import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExpensesCSVReadTransformer {

    public ExpensesRecord transformFromCSV(String[] budgetRecordStrings) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(budgetRecordStrings[1]));
        final ExpensesCategory category = ExpensesCategory.
                valueOf(budgetRecordStrings[2].toUpperCase().replace(' ', '_'));
        final LocalDateTime date = LocalDateTime.parse(budgetRecordStrings[3], dateTimeFormatter);
        final PaymentType paymentType = PaymentType.
                valueOf(budgetRecordStrings[4].toUpperCase().replace(' ', '_'));
        final String otherInformation = budgetRecordStrings[7];

        if (paymentType == PaymentType.GRYNIEJI) {
            return new ExpensesRecord(amount, category, date, paymentType, otherInformation);
        } else {
            return new ExpensesRecord(amount, category, date, paymentType,
                    new BankCard(budgetRecordStrings[5],
                    CardType.valueOf(budgetRecordStrings[6].toUpperCase().replace(' ', '_'))),
                    otherInformation);
        }
    }
}
