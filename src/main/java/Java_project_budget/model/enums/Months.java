package Java_project_budget.model.enums;

public enum Months {
    SAUSIS("Sausis", 31, 31),
    VASARIS("Vasaris", 28, 29),
    KOVAS("Kovas", 31, 31),
    BALANDIS("Balandis", 30, 30),
    GEGUZĖ("Gegužė", 31, 31),
    BIRZELIS("Birželis", 30, 30),
    LIEPA("Liepa", 31, 31),
    RUGPJUTIS("Rugpjūtis", 31, 31),
    RUGSEJIS("Rugsėjis", 30, 30),
    SPALIS("Spalis", 31, 31),
    LAPKRITIS("Lapkritis", 30, 30),
    GRUODIS("Gruodis", 31, 31);

    private final String printLT;
    private final int dayCountNotLeapYear;
    private final int dayCountLeapYear;

    Months(final String printLT, final int dayCountNotLeapYear,
           final int dayCountLeapYear) {
        this.printLT = printLT;
        this.dayCountNotLeapYear = dayCountNotLeapYear;
        this.dayCountLeapYear = dayCountLeapYear;
    }

    public String getPrintLT() {
        return printLT;
    }

    public int getDayCountNotLeapYear() {
        return dayCountNotLeapYear;
    }

    public int getDayCountLeapYear() {
        return dayCountLeapYear;
    }
}
