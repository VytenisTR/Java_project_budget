package Java_project_budget.model.input.expenses;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.AmountInput;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public final class ExpensesAmountInput implements AmountInput {

    public BigDecimal enterAmount() {
        BigDecimal amount = BigDecimal.valueOf(0D);

        while(amount.doubleValue() <= 0D) {
            PrintMessages.printMessageWithoutNewLine("\nĮveskite išlaidų sumą: ");

            try {
                amount = BigDecimal.valueOf(SC.nextDouble());

                if (amount.doubleValue() <= 0D)
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Išlaidų suma negali būti mažesnė arba lygi nuliui.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine("\nAptikta tekstinė įvestis " +
                        "arba skaičiams atskirti vietoje kablelio buvo panaudotas taškas!\n" +
                        "Prašome nurodyti gautų pajamų sumą skaičiais, o prireikus juos atskirti kableliu.");
                SC.nextLine();
            }
        }

        return amount;
    }
}
