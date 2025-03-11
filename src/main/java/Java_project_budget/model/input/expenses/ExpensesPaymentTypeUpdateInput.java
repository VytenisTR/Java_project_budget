package Java_project_budget.model.input.expenses;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.ScannerInput;
import Java_project_budget.model.enums.PaymentType;
import Java_project_budget.model.input.utils.DisplayPaymentTypes;
import java.util.InputMismatchException;

public final class ExpensesPaymentTypeUpdateInput implements ScannerInput {

    public PaymentType enterPaymentType() {
        PaymentType paymentType = null;

        while(paymentType == null) {
            DisplayPaymentTypes.printPaymentTypesForUpdate();

            PrintMessages.printMessageWithoutNewLine("\nPasirinkite atsiskaitymo būdą, " +
                    "įvesdami jo numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> paymentType = PaymentType.APPLEPAY;
                    case 2 -> paymentType = PaymentType.GOOGLEPAY;
                    case 3 -> paymentType = PaymentType.BANKINE_KORTELE;
                    case 4 -> paymentType = PaymentType.BANKINIS_PAVEDIMAS;
                    default -> paymentType = null;
                }

                if (paymentType == null)
                    PrintMessages.printMessageWithNewLine
                            ("\nKlaidinga įvestis! Toks atsiskaitymo būdas neegzistuoja!\n" +
                            "Prašome įvesti atsiskaitymo būdo " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 4).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti atsiskaitymo būdo " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 4).");
                SC.nextLine();
            }
        }

        return paymentType;
    }
}
