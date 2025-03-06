package Java_project_budget.model.input.income;

import Java_project_budget.model.input.utils.DisplayIncomeCategories;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class IncomeCategoryInput {
    private static final Scanner SC = new Scanner(System.in);

    public Java_project_budget.model.enums.IncomeCategory enterIncomeCategory() {
        Java_project_budget.model.enums.IncomeCategory incomeCategory = null;

        while(incomeCategory == null) {
            DisplayIncomeCategories.printIncomeCategories();

            System.out.print("\nPasirinkite gautų pajamų kategoriją, " +
                    "įvesdami kategorijos numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.DARBO_UŽMOKESTIS;
                    case 2 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.DIVIDENDAI;
                    case 3 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.SOCIALINĖS_IŠMOKOS;
                    case 4 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.KOMISINIAI;
                    case 5 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.PALŪKANOS;
                    case 6 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.PENSIJA;
                    case 7 -> incomeCategory = Java_project_budget.model.enums.IncomeCategory.PRIEDAI;
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
