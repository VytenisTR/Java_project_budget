package project.budget.services.files.transformers;

import project.domain.data.ExpensesRecord;

public final class ExpensesCSVWriteTransformer {
    private static final String DELIMITER = ",";

    public String transformToCSV(final ExpensesRecord expensesRecord) {
        if (expensesRecord.getPaymentType().getPrintLT().equals("Grynieji")) {
            return String.format("%s%s%.2f%s%s%s%s%s%s%s%s%s%s%s%s\n", "Expenses", DELIMITER,
                    expensesRecord.getAmount(), DELIMITER,
                    expensesRecord.getCategory(), DELIMITER,
                    expensesRecord.getDate(), DELIMITER,
                    expensesRecord.getPaymentType(), DELIMITER,
                    "", DELIMITER,
                    "", DELIMITER,
                    expensesRecord.getOtherInformation());
        } else {
            return String.format("%s%s%.2f%s%s%s%s%s%s%s%s%s%s%s%s\n", "Expenses", DELIMITER,
                    expensesRecord.getAmount(), DELIMITER,
                    expensesRecord.getCategory(), DELIMITER,
                    expensesRecord.getDate(), DELIMITER,
                    expensesRecord.getPaymentType(), DELIMITER,
                    expensesRecord.getBankCard().getNumber(), DELIMITER,
                    expensesRecord.getBankCard().getCardType(), DELIMITER,
                    expensesRecord.getOtherInformation());
        }
    }
}
