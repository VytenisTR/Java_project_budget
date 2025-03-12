package project.input.income;

import project.budget.utils.PrintMessages;
import project.domain.interfaces.ScannerInput;
import project.enums.IncomeCategory;
import project.input.utils.display.DisplayIncomeCategories;
import java.util.InputMismatchException;

public final class IncomeCategoryInput implements ScannerInput {

    public IncomeCategory enterIncomeCategory() {
        IncomeCategory incomeCategory = null;

        while(incomeCategory == null) {
            DisplayIncomeCategories.printIncomeCategories();

            PrintMessages.printMessageWithoutNewLine("\nPasirinkite gautų pajamų kategoriją, " +
                    "įvesdami kategorijos numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> incomeCategory = IncomeCategory.DARBO_UZMOKESTIS;
                    case 2 -> incomeCategory = IncomeCategory.DIVIDENDAI;
                    case 3 -> incomeCategory = IncomeCategory.SOCIALINES_ISMOKOS;
                    case 4 -> incomeCategory = IncomeCategory.KOMISINIAI;
                    case 5 -> incomeCategory = IncomeCategory.PALUKANOS;
                    case 6 -> incomeCategory = IncomeCategory.PENSIJA;
                    case 7 -> incomeCategory = IncomeCategory.PRIEDAI;
                    default -> incomeCategory = null;
                }

                if (incomeCategory == null)
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Pasirinkta pajamų kategorija yra neegzistuojanti!\n" +
                            "Prašome pasirinkti pajamų kategorijos " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 7).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti gautų pajamų kategorijos " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 7).");
                SC.nextLine();
            }
        }

        return incomeCategory;
    }
}
