package Java_project_budget.model.enums;

public enum CardType {
    KREDITINE("Kreditinė"),
    DEBETINE("Debetinė");

    private final String printLT;

    CardType(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
