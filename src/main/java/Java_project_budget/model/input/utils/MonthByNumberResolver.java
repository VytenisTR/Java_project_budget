package Java_project_budget.model.input.utils;

import Java_project_budget.model.enums.Months;

public final class MonthByNumberResolver {

    public static Months getMonthByNumber(final int monthNumber) {
        Months month = null;

        switch(monthNumber) {
            case 1 -> month = Months.SAUSIS;
            case 2 -> month = Months.VASARIS;
            case 3 -> month = Months.KOVAS;
            case 4 -> month = Months.BALANDIS;
            case 5 -> month = Months.GEGUZĖ;
            case 6 -> month = Months.BIRZELIS;
            case 7 -> month = Months.LIEPA;
            case 8 -> month = Months.RUGPJUTIS;
            case 9 -> month = Months.RUGSEJIS;
            case 10 -> month = Months.SPALIS;
            case 11 -> month = Months.LAPKRITIS;
            case 12 -> month = Months.GRUODIS;
            default -> month = null;
        }

        return month;
    }
}
