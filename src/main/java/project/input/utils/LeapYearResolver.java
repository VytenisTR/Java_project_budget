package project.input.utils;

public final class LeapYearResolver {

    public static boolean isLeapYear(final int year) {
        boolean isLeapYear = false;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 ==0) {
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        return isLeapYear;
    }
}
