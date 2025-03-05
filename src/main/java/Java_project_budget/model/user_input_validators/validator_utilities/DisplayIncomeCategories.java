package Java_project_budget.model.user_input_validators.validator_utilities;

import Java_project_budget.model.enums.IncomeCategory;

public final class DisplayIncomeCategories {

    public static void printIncomeCategories() {
        System.out.println("\nPajamų kategorijų sąrašas:");

        for (int i = 0; i < IncomeCategory.values().length; i++) {
            System.out.printf("[%d] - %s\n", i + 1, IncomeCategory.values()[i].getPrintLT());
        }
    }
}
