package project.input.record_id;

import project.budget.utils.PrintMessages;
import project.domain.interfaces.IdInput;
import java.util.InputMismatchException;

public final class ExpensesIdToBeUpdatedInput implements IdInput{

    public int enterId() {
        int id = 0;

        while(id <= 0) {
            PrintMessages.printMessageWithoutNewLine
                    ("\nIš pateikto sąrašo įveskite unikalų išlaidų įrašo, " +
                    "kurį norite redaguoti, numerį: ");

            try {
                id = SC.nextInt();

                if (id <= 0)
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Išlaidų įrašo unikalus numeris negali būti neigiamas arba lygus nuliui.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti išlaidų įrašų unikalų numerį skaičiais.");
                SC.nextLine();
            }
        }

        return id;
    }
}
