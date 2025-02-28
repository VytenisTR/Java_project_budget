package Java_project_budget.model.enums;

public enum ExpensesCategory {
    AVALYNĖ("Avalynė"),
    BALDAI("Baldai"),
    DRABUŽIAI("Drabužiai"),
    DRAUDIMAS("Draudimas"),
    ELEKTRONIKOS_PRIETAISAI("Elektronikos prietaisai"),
    GROŽIO_ĮRANKIAI("Grožio įrankiai"),
    KELIONĖS("Kelionės"),
    KITI_MOKESČIAI("Kiti mokesčiai"),
    KOMUNALINIAI_MOKESČIAI("Komunaliniai mokesčiai"),
    KURAS("Kuras"),
    LICENZIJOS("Licenzijos"),
    MAISTAS("Maistas"),
    NAMŲ_APYVOKOS_ĮRANKIAI("Namų apyvokos įrankiai"),
    PASKOLOS("Paskolos");

    private final String printLT;

    ExpensesCategory(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
