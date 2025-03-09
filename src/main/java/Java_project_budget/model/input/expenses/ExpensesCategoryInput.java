package Java_project_budget.model.input.expenses;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.input.utils.DisplayExpensesCategories;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class ExpensesCategoryInput {
    private static final Scanner SC = new Scanner(System.in);

    public ExpensesCategory enterExpensesCategory() {
        ExpensesCategory expensesCategory = null;

        while(expensesCategory == null) {
            DisplayExpensesCategories.printExpensesCategories();

            PrintMessages.printMessageWithoutNewLine("\nPasirinkite išlaidų kategoriją, " +
                    "įvesdami kategorijos numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> expensesCategory = ExpensesCategory.AVALYNE;
                    case 2 -> expensesCategory = ExpensesCategory.BALDAI;
                    case 3 -> expensesCategory = ExpensesCategory.DRABUZIAI;
                    case 4 -> expensesCategory = ExpensesCategory.DRAUDIMAS;
                    case 5 -> expensesCategory = ExpensesCategory.ELEKTRONIKOS_PRIETAISAI;
                    case 6 -> expensesCategory = ExpensesCategory.GROZIO_IRANKIAI;
                    case 7 -> expensesCategory = ExpensesCategory.KELIONES;
                    case 8 -> expensesCategory = ExpensesCategory.KITI_MOKESCIAI;
                    case 9 -> expensesCategory = ExpensesCategory.KOMUNALINIAI_MOKESCIAI;
                    case 10 -> expensesCategory = ExpensesCategory.KURAS;
                    case 11 -> expensesCategory = ExpensesCategory.LICENZIJOS;
                    case 12 -> expensesCategory = ExpensesCategory.MAISTAS;
                    case 13 -> expensesCategory = ExpensesCategory.NAMU_APYVOKOS_IRANKIAI;
                    case 14 -> expensesCategory = ExpensesCategory.PASKOLOS;
                    default -> expensesCategory = null;
                }

                if (expensesCategory == null)
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Pasirinkta išlaidų kategorija yra neegzistuojanti!\n" +
                            "Prašome pasirinkti išlaidų kategorijos " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 14).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti išlaidų kategorijos " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 14).");
                SC.nextLine();
            }
        }

        return expensesCategory;
    }
}
