package Java_project_budget.model.enums;

public enum PaymentType {
    APPLEPAY("Applepay"),
    GOOGLEPAY("Googlepay"),
    GRYNIEJI("Grynieji"),
    BANKINĖ_KORTELĖ("Bankinė kortelė"),
    BANKINIS_PAVEDIMAS("Bankinis pavedimas");

    private final String printLT;

    PaymentType(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
