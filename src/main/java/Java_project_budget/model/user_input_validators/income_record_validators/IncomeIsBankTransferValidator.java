package Java_project_budget.model.user_input_validators.income_record_validators;

import Java_project_budget.model.user_input_validators.validator_utilities.DisplayMeniuBankTransfer;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class IncomeIsBankTransferValidator {
    private static final Scanner SC = new Scanner(System.in);

    public boolean isBankTransfer() {
        int isBankTransfer = -1;

        while(isBankTransfer < 0) {
            DisplayMeniuBankTransfer.displayMeniu();

            System.out.print("\nNurodykite ar pajamos buvo gautos į banko sąskaitą, " +
                    "įvesdami pasirinkimo numerį iš pateikto pasirinkimų sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> isBankTransfer = 1;
                    case 2 -> isBankTransfer = 0;
                    default -> isBankTransfer = -1;
                }

                if (isBankTransfer < 0)
                    System.out.println("\nKlaidinga įvestis! Toks pasirinkimas neegzistuoja!\n" +
                            "Prašome pasirinkti reikšmę iš pateikto pasirinkimų sąrašo " +
                            "(skaičių 1 arba 2).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti reikšmę iš pateikto pasirinkimų sąrašo " +
                        "(skaičių 1 arba 2).\n");
                SC.nextLine();
            }
        }

        return isBankTransfer == 1;
    }
}
