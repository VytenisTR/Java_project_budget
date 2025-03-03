package Java_project_budget.model.user_input_validators.expenses_record_validators;

import Java_project_budget.model.enums.PaymentType;
import Java_project_budget.model.user_input_validators.validator_utilities.DisplayPaymentTypes;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class ExpensesPaymentTypeValidator {
    private static final Scanner SC = new Scanner(System.in);

    public PaymentType enterPaymentType() {
        PaymentType paymentType = null;

        while(paymentType == null) {
            DisplayPaymentTypes.printPaymentTypes();

            System.out.print("\nPasirinkite atsiskaitymo būdą, " +
                    "įvesdami jo numerį iš pateikto sąrašo: ");

            try {
                switch(SC.nextInt()) {
                    case 1 -> paymentType = PaymentType.APPLEPAY;
                    case 2 -> paymentType = PaymentType.GOOGLEPAY;
                    case 3 -> paymentType = PaymentType.GRYNIEJI;
                    case 4 -> paymentType = PaymentType.BANKINĖ_KORTELĖ;
                    case 5 -> paymentType = PaymentType.BANKINIS_PAVEDIMAS;
                    default -> paymentType = null;
                }

                if (paymentType == null)
                    System.out.println("\nKlaidinga įvestis! Toks atsiskaitymo būdas neegzistuoja!\n" +
                            "Prašome įvesti atsiskaitymo būdo " +
                            "numerį iš pateikto sąrašo (skaičių nuo 1 iki 5).");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome įvesti atsiskaitymo būdo " +
                        "numerį iš pateikto sąrašo (skaičių nuo 1 iki 5).");
                SC.nextLine();
            }
        }

        return paymentType;
    }
}
