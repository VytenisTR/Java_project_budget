package Java_project_budget.model.user_input_validators.validator_utilities;

import Java_project_budget.model.enums.ExpensesCategory;

public final class DisplayExpensesCategories {

    public static void printExpensesCategories() {
        System.out.println();
        System.out.println("Išlaidų kategorijų sąrašas:");

        for (int i = 0; i < ExpensesCategory.values().length; i++) {
            System.out.printf("%d. %s\n", i + 1, ExpensesCategory.values()[i].getPrintLT());
        }
    }
}
