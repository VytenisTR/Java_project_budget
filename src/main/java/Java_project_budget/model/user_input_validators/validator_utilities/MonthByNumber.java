package Java_project_budget.model.user_input_validators.validator_utilities;

import Java_project_budget.model.enums.Months;

public final class MonthByNumber {

    public static Months getMonthByNumber(final int monthNumber) {
        Months month = null;

        switch(monthNumber) {
            case 1 -> month = Months.SAUSIS;
            case 2 -> month = Months.VASARIS;
            case 3 -> month = Months.KOVAS;
            case 4 -> month = Months.BALANDIS;
            case 5 -> month = Months.GEGUŽĖ;
            case 6 -> month = Months.BIRŽELIS;
            case 7 -> month = Months.LIEPA;
            case 8 -> month = Months.RUGPJŪTIS;
            case 9 -> month = Months.RUGSĖJIS;
            case 10 -> month = Months.SPALIS;
            case 11 -> month = Months.LAPKRITIS;
            case 12 -> month = Months.GRUODIS;
            default -> month = null;
        }

        return month;
    }
}
