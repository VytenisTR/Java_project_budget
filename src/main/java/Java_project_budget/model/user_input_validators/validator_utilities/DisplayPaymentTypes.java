package Java_project_budget.model.user_input_validators.validator_utilities;

import Java_project_budget.model.enums.PaymentType;

public final class DisplayPaymentTypes {

    public static void printPaymentTypes() {
        System.out.println("\nAtsiskaitymo būdų sąrašas:");

        for (int i = 0; i < PaymentType.values().length; i++) {
            System.out.printf("%d. %s\n", i + 1, PaymentType.values()[i].getPrintLT());
        }
    }
}
