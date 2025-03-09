package Java_project_budget.model.budget.services.files.utils;

import java.util.List;

public final class FileReadUtilities {

    public static boolean checkIfIncomeRecordExists(List<String> inputFromCSV) {
        boolean result = false;

        for (String string : inputFromCSV) {
            final String[] incomeRecordStrings = string.split(",");
            if (incomeRecordStrings.length == 6) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static boolean checkIfExpensesRecordExists(List<String> inputFromCSV) {
        boolean result = false;

        for (String string : inputFromCSV) {
            final String[] expensesRecordStrings = string.split(",");
            if (expensesRecordStrings.length != 6) {
                result = true;
                break;
            }
        }

        return result;
    }
}
