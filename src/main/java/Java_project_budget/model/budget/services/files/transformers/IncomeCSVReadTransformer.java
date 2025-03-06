package Java_project_budget.model.budget.services.files.transformers;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.enums.IncomeCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class IncomeCSVReadTransformer {

    public IncomeRecord transformFromCSV(String[] budgetRecordStrings) {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        final BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(budgetRecordStrings[1]));
        final IncomeCategory category = IncomeCategory.
                valueOf(budgetRecordStrings[2].toUpperCase().replace(' ', '_'));
        final LocalDateTime date = LocalDateTime.parse(budgetRecordStrings[3], dateTimeFormatter);
        final boolean isBankTransfer = budgetRecordStrings[4].equals("Taip");
        final String otherInformation = budgetRecordStrings[5];

        return new IncomeRecord(amount, category, date, isBankTransfer, otherInformation);
    }
}
