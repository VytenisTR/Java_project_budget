package Java_project_budget.model.input.common.record_id;

import Java_project_budget.model.domain.parent.IdInput;
import java.util.InputMismatchException;

public final class IncomeIdToBeRemovedInput extends IdInput {

    public int enterId() {
        int id = 0;

        while(id <= 0) {
            System.out.print("\nIš pateikto sąrašo įveskite unikalų pajamų įrašo, " +
                    "kurį norite pašalinti, numerį: ");

            try {
                id = SC.nextInt();

                if (id <= 0)
                    System.out.println("\nKlaidinga įvestis! " +
                            "Pajamų įrašo unikalus numeris negali būti neigiamas arba lygus nuliui.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti pajamų įrašų unikalų numerį skaičiais.");
                SC.nextLine();
            }
        }

        return id;
    }
}
