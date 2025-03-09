package Java_project_budget.model.enums;

public enum ExpensesCategory {
    AVALYNE("Avalynė"),
    BALDAI("Baldai"),
    DRABUZIAI("Drabužiai"),
    DRAUDIMAS("Draudimas"),
    ELEKTRONIKOS_PRIETAISAI("Elektronikos prietaisai"),
    GROZIO_IRANKIAI("Grožio įrankiai"),
    KELIONES("Kelionės"),
    KITI_MOKESCIAI("Kiti mokesčiai"),
    KOMUNALINIAI_MOKESCIAI("Komunaliniai mokesčiai"),
    KURAS("Kuras"),
    LICENZIJOS("Licenzijos"),
    MAISTAS("Maistas"),
    NAMU_APYVOKOS_IRANKIAI("Namų apyvokos įrankiai"),
    PASKOLOS("Paskolos");

    private final String printLT;

    ExpensesCategory(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
