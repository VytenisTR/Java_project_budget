package Java_project_budget.model.user_input_validators.income_record_validators;

import Java_project_budget.model.enums.IncomeCategory;
import Java_project_budget.model.user_input_validators.validator_utilities.DisplayIncomeCategories;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class IncomeCategoryValidator {
    private static final Scanner SC = new Scanner(System.in);

    public IncomeCategory enterIncomeCategory() {
        IncomeCategory incomeCategory = null;

        while(incomeCategory == null) {
            DisplayIncomeCategories.printIncomeCategories();

            System.out.print("\nPasirinkite gautų pajamų kategoriją, " +
                    "įvesdami kategorijos numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> incomeCategory = IncomeCategory.DARBO_UŽMOKESTIS;
                    case 2 -> incomeCategory = IncomeCategory.DIVIDENDAI;
                    case 3 -> incomeCategory = IncomeCategory.SOCIALINĖS_IŠMOKOS;
                    case 4 -> incomeCategory = IncomeCategory.KOMISINIAI;
                    case 5 -> incomeCategory = IncomeCategory.PALŪKANOS;
                    case 6 -> incomeCategory = IncomeCategory.PENSIJA;
                    case 7 -> incomeCategory = IncomeCategory.PRIEDAI;
                    default -> incomeCategory = null;
                }

                if (incomeCategory == null)
                    System.out.println("\nKlaidinga įvestis! " +
                            "Pasirinkta pajamų kategorija yra neegzistuojanti!\n" +
                            "Prašome pasirinkti pajamų kategorijos " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 7).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti gautų pajamų kategorijos " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 7).");
                SC.nextLine();
            }
        }

        return incomeCategory;
    }
}
