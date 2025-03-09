package Java_project_budget.model.input.income.date;

import Java_project_budget.model.budget.utils.PrintMessages;
import Java_project_budget.model.domain.interfaces.YearInput;
import java.time.LocalDate;
import java.util.InputMismatchException;

public final class IncomeYearInput implements YearInput {

    public int enterYear() {
        int year = 0;

        while(year < LocalDate.now().minusYears(5).getYear() ||
                year > LocalDate.now().getYear()) {
            PrintMessages.printMessageWithoutNewLine("\nĮveskite metus, kuriais buvo gautos pajamos: ");

            try {
                year = SC.nextInt();

                if (String.valueOf(year).length() != 4)
                    PrintMessages.printMessageWithNewLine
                            ("\nKlaidinga įvestis! Per didelis arba per mažas simbolių kiekis!\n" +
                            "Metus turi sudaryti 4 simboliai.");
                else if (year < LocalDate.now().minusYears(5).getYear())
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Metai negali būti ankstesni už praėjusius penkerius metus.");
                else if (year > LocalDate.now().getYear())
                    PrintMessages.printMessageWithNewLine("\nKlaidinga įvestis! " +
                            "Metai negali būti vėlesni už einamuosius metus.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                PrintMessages.printMessageWithNewLine
                        ("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti metus skaičiais.");
                SC.nextLine();
            }
        }

        return year;
    }
}
