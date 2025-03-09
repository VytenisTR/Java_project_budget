package Java_project_budget.model.budget.services.files.transformers;

import Java_project_budget.model.domain.data.IncomeRecord;

public final class IncomeCSVWriteTransformer {
    private static final String DELIMITER = ",";

    public String transformToCSV(final IncomeRecord incomeRecord) {
        return String.format("%s%s%.2f%s%s%s%s%s%s%s%s\n", "Income", DELIMITER,
                incomeRecord.getAmount(), DELIMITER,
                incomeRecord.getCategory(), DELIMITER,
                incomeRecord.getDate(), DELIMITER,
                incomeRecord.getIsBankTransfer(), DELIMITER,
                incomeRecord.getOtherInformation());
    }
}
