package Java_project_budget.model.input.income;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.ScannerInput;
import Java_project_budget.model.input.utils.DisplayMeniuIsBankTransfer;
import java.util.InputMismatchException;

public final class IncomeIsBankTransferInput implements ScannerInput {

    public boolean isBankTransfer() {
        int isBankTransfer = -1;

        while(isBankTransfer < 0) {
            DisplayMeniuIsBankTransfer.displayMeniu();

            PrintMessages.printMessageWithoutNewLine
                    ("\nNurodykite ar pajamos buvo gautos į banko sąskaitą, " +
                    "įvesdami pasirinkimo numerį iš pateikto pasirinkimų sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> isBankTransfer = 1;
                    case 2 -> isBankTransfer = 0;
                    default -> isBankTransfer = -1;
                }

                if (isBankTransfer < 0)
                    PrintMessages.printMessageWithNewLine
                            ("\nKlaidinga įvestis! Toks pasirinkimas neegzistuoja!\n" +
                            "Prašome pasirinkti reikšmę iš pateikto pasirinkimų sąrašo " +
                            "(skaičių 1 arba 2).\n");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome pasirinkti reikšmę iš pateikto pasirinkimų sąrašo " +
                        "(skaičių 1 arba 2).\n");
                SC.nextLine();
            }
        }

        return isBankTransfer == 1;
    }
}
