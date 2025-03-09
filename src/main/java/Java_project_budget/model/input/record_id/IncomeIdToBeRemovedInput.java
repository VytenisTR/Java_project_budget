package Java_project_budget.model.input.record_id;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.IdInput;
import java.util.InputMismatchException;

public final class IncomeIdToBeRemovedInput implements IdInput{

    public int enterId() {
        int id = 0;

        while(id <= 0) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nIš pateikto sąrašo įveskite unikalų pajamų įrašo, " +
                    "kurį norite pašalinti, numerį: ");

            try {
                id = SC.nextInt();

                if (id <= 0)
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Pajamų įrašo unikalus numeris negali būti neigiamas arba lygus nuliui.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti pajamų įrašų unikalų numerį skaičiais.");
                SC.nextLine();
            }
        }

        return id;
    }
}
