package Java_project_budget.model.input.utils;

import Java_project_budget.model.enums.Months;

public final class DisplayMonths {

    public static void printMonths() {
        System.out.println("\nMėnesių sąrašas:");

        for (int i = 0; i < Months.values().length; i++) {
            System.out.printf("[%d] - %s\n", i + 1, Months.values()[i].getPrintLT());
        }
    }
}
