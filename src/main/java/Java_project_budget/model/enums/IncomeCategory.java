package Java_project_budget.model.enums;

public enum IncomeCategory {
    DARBO_UŽMOKESTIS("Darbo užmokestis"),
    DIVIDENDAI("Dividendai"),
    SOCIALINĖS_IŠMOKOS("Socialinės išmokos"),
    KOMISINIAI("Komisiniai"),
    PALŪKANOS("Palūkanos"),
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
