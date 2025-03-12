package project.enums;

public enum PaymentType {
    APPLEPAY("Applepay"),
    GOOGLEPAY("Googlepay"),
    GRYNIEJI("Grynieji"),
    BANKINE_KORTELE("Bankinė kortelė"),
    BANKINIS_PAVEDIMAS("Bankinis pavedimas");

    private final String printLT;

    PaymentType(final String printLT) {
        this.printLT = printLT;
    }

    public String getPrintLT() {
        return printLT;
    }
}
