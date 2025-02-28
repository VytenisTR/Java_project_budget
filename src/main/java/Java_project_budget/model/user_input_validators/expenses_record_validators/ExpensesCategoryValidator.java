package Java_project_budget.model.user_input_validators.expenses_record_validators;

import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.user_input_validators.validator_utilities.DisplayExpensesCategories;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class ExpensesCategoryValidator {
    private static final Scanner SC = new Scanner(System.in);

    public ExpensesCategory enterExpensesCategory() {
        ExpensesCategory expensesCategory = null;

        while(expensesCategory == null) {
            DisplayExpensesCategories.printExpensesCategories();

            System.out.print("\nPasirinkite išlaidų kategoriją, " +
                    "įvesdami kategorijos numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> expensesCategory = ExpensesCategory.AVALYNĖ;
                    case 2 -> expensesCategory = ExpensesCategory.BALDAI;
                    case 3 -> expensesCategory = ExpensesCategory.DRABUŽIAI;
                    case 4 -> expensesCategory = ExpensesCategory.DRAUDIMAS;
                    case 5 -> expensesCategory = ExpensesCategory.ELEKTRONIKOS_PRIETAISAI;
                    case 6 -> expensesCategory = ExpensesCategory.GROŽIO_ĮRANKIAI;
                    case 7 -> expensesCategory = ExpensesCategory.KELIONĖS;
                    case 8 -> expensesCategory = ExpensesCategory.KITI_MOKESČIAI;
                    case 9 -> expensesCategory = ExpensesCategory.KOMUNALINIAI_MOKESČIAI;
                    case 10 -> expensesCategory = ExpensesCategory.KURAS;
                    case 11 -> expensesCategory = ExpensesCategory.LICENZIJOS;
                    case 12 -> expensesCategory = ExpensesCategory.MAISTAS;
                    case 13 -> expensesCategory = ExpensesCategory.NAMŲ_APYVOKOS_ĮRANKIAI;
                    case 14 -> expensesCategory = ExpensesCategory.PASKOLOS;
                    default -> expensesCategory = null;
                }

                if (expensesCategory == null)
                    System.out.println("\nKlaidinga įvestis! " +
                            "Pasirinkta išlaidų kategorija yra neegzistuojanti!\n" +
                            "Prašome pasirinkti išlaidų kategorijos " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 14).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti išlaidų kategorijos " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 14).");
                SC.nextLine();
            }
        }

        return expensesCategory;
    }
}
