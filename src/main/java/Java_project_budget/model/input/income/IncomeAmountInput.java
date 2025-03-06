package Java_project_budget.model.input.income;

import Java_project_budget.model.domain.parent.AmountInput;
import java.math.BigDecimal;
import java.util.InputMismatchException;

public final class IncomeAmountInput extends AmountInput {

    public BigDecimal enterAmount() {
        BigDecimal amount = BigDecimal.valueOf(0D);

        while(amount.doubleValue() <= 0D) {
            System.out.print("\nĮveskite gautų pajamų sumą: ");

            try {
                amount = BigDecimal.valueOf(SC.nextDouble());

                if (amount.doubleValue() <= 0D)
                    System.out.println("\nKlaidinga įvestis! " +
                            "Pajamų suma negali būti mažesnė arba lygi nuliui.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis " +
                        "arba skaičiams atskirti vietoje kablelio buvo panaudotas taškas!\n" +
                        "Prašome nurodyti gautų pajamų sumą skaičiais, o prireikus juos atskirti kableliu.");
                SC.nextLine();
            }
        }

        return amount;
    }
}
