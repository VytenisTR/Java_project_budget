package Java_project_budget.model.budget.services.files.transformers;

import Java_project_budget.model.domain.data.ExpensesRecord;

public final class ExpensesCSVWriteTransformer {
    private static final String DELIMITER = ",";

    public String transformToCSV(final ExpensesRecord expensesRecord) {
        if (expensesRecord.getPaymentType().equals("Grynieji")) {
            return String.format("%s%s%.2f%s%s%s%s%s%s%s%s%s%s%s%s%s\n", "Expenses", DELIMITER,
                    expensesRecord.getAmount(), DELIMITER,
                    expensesRecord.getCategory(), DELIMITER,
                    expensesRecord.getDate(), DELIMITER,
                    expensesRecord.getPaymentType(), DELIMITER,
                    "Banko kortelės numerio informacijos nėra", DELIMITER,
                    "Banko kortelės tipo informacijos nėra", DELIMITER,
                    expensesRecord.getOtherInformation(), DELIMITER);
        } else {
            return String.format("%s%s%.2f%s%s%s%s%s%s%s%s%s%s%s%s%s\n", "Expenses", DELIMITER,
                    expensesRecord.getAmount(), DELIMITER,
                    expensesRecord.getCategory(), DELIMITER,
                    expensesRecord.getDate(), DELIMITER,
                    expensesRecord.getPaymentType(), DELIMITER,
                    expensesRecord.getBankCard().getNumber(), DELIMITER,
                    expensesRecord.getBankCard().getCardType(), DELIMITER,
                    expensesRecord.getOtherInformation(), DELIMITER);
        }
    }
}
