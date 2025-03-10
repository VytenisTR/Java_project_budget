package Java_project_budget.model.budget.services.files.transformers;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.enums.IncomeCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public final class IncomeCSVReadTransformer {

    public IncomeRecord transformFromCSV(String[] budgetRecordStrings) {
        try {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            final BigDecimal amount = BigDecimal.valueOf(Double.parseDouble(budgetRecordStrings[1].
                    concat(".").concat(budgetRecordStrings[2])));
            final IncomeCategory category = IncomeCategory.valueOf(budgetRecordStrings[3]);
            final LocalDateTime date = LocalDateTime.parse(budgetRecordStrings[4], dateTimeFormatter);
            final boolean isBankTransfer = budgetRecordStrings[5].equals("Taip");
            final String otherInformation = budgetRecordStrings[6];

            return new IncomeRecord(amount, category, date, isBankTransfer, otherInformation);
        } catch (NullPointerException | IllegalArgumentException | DateTimeParseException exception) {
            return null;
        }
    }
}
