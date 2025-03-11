package Java_project_budget.model.input.utils;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.enums.PaymentType;

public final class DisplayPaymentTypes {

    public static void printPaymentTypes() {
        PrintMessages.printMessageWithNewLine("\nAtsiskaitymo būdų sąrašas:");

        for (int i = 0; i < PaymentType.values().length; i++) {
            PrintMessages.printMessageWithoutNewLine(
                    String.format("[%d] - %s\n", i + 1, PaymentType.values()[i].getPrintLT()));
        }
    }

    public static void printPaymentTypesForUpdate() {
        PrintMessages.printMessageWithNewLine("\nAtsiskaitymo būdų sąrašas:");

        for (int i = 0; i < PaymentType.values().length; i++) {
            if (i == 2) {
                continue;
            } else if (i > 2) {
                PrintMessages.printMessageWithoutNewLine(
                        String.format("[%d] - %s\n", i, PaymentType.values()[i].getPrintLT()));
            } else {
                PrintMessages.printMessageWithoutNewLine(
                        String.format("[%d] - %s\n", i + 1, PaymentType.values()[i].getPrintLT()));
            }
        }
    }
}
