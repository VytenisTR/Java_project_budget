package Java_project_budget.model.input.common.date;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class YearInput {
    private static final Scanner SC = new Scanner(System.in);

    public int enterYear() {
        int year = 0;

        while(year < LocalDate.now().minusYears(5).getYear() ||
                year > LocalDate.now().getYear()) {
            System.out.print("\nĮveskite metus, kuriais buvo gautos pajamos: ");

            try {
                year = SC.nextInt();

                if (String.valueOf(year).length() != 4)
                    System.out.println("\nKlaidinga įvestis! Per didelis arba per mažas simbolių kiekis!\n" +
                            "Metus turi sudaryti 4 simboliai.");
                else if (year < LocalDate.now().minusYears(5).getYear())
                    System.out.println("\nKlaidinga įvestis! " +
                            "Metai negali būti ankstesni už praėjusius penkerius metus.");
                else if (year > LocalDate.now().getYear())
                    System.out.println("\nKlaidinga įvestis! " +
                            "Metai negali būti vėlesni už einamuosius metus.");
            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("\nAptikta tekstinė įvestis arba įvestas skaičius su kableliu!\n" +
                        "Prašome nurodyti metus skaičiais.");
                SC.nextLine();
            }
        }

        return year;
    }
}
