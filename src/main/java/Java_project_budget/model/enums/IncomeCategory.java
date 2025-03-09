package Java_project_budget.model.enums;

public enum IncomeCategory {
    DARBO_UZMOKESTIS("Darbo užmokestis"),
    DIVIDENDAI("Dividendai"),
    SOCIALINES_ISMOKOS("Socialinės išmokos"),
    KOMISINIAI("Komisiniai"),
    PALUKANOS("Palūkanos"),
    PENSIJA("Pensija"),
    PRIEDAI("Priedai");

    private final String printLT;

    IncomeCategory(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
