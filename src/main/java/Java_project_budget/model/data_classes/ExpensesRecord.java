package Java_project_budget.model.data_classes;

import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.enums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExpensesRecord {
    private long idCount = 1;
    private final long id;
    private final BigDecimal amount;
    private final ExpensesCategory category;
    private final LocalDateTime date;
    private final PaymentType paymentType;
    private final BankCard bankCard;
    private final String otherInformation;

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category,
                          final LocalDateTime date, final PaymentType paymentType,
                          final BankCard bankCard, final String otherInformation) {
        this.id = idCount;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.paymentType = paymentType;
        this.bankCard = bankCard;
        this.otherInformation = otherInformation;
        idCount++;
    }

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category,
                          final LocalDateTime date, final PaymentType paymentType,
                          final String otherInformation) {
        this.id = idCount;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.paymentType = paymentType;
        this.bankCard = null;
        this.otherInformation = otherInformation;
        idCount++;
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    public String getCategory() {
        return category.getPrintLT();
    }

    public String getDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(dateTimeFormatter);
    }

    public String getPaymentType() {
        return paymentType.getPrintLT();
    }

    public String getBankCardInfo() {
        if (bankCard == null)
            return "Banko kortelės informacija nepasiekiama, kadangi buvo atsiskaityta ne banko kortele.";
        else
            return bankCard.toString();
    }

    public String getOtherInformation() {
        if (otherInformation.isBlank())
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
    }

    @Override
    public String toString() {
        if (bankCard == null) {
            return String.format("Unikalus išlaidų įrašo numeris: %d\n" +
                            "Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "Papildoma informacija: %s\n", getId(), getAmount(), getCategory(),
                    getDate(), getPaymentType(), getOtherInformation());
        } else {
            return String.format("Unikalus išlaidų įrašo numeris: %d\n" +
                            "Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "%s" + //Banko kortelės informacija
                            "Papildoma informacija: %s\n", getId(), getAmount(), getCategory(),
                    getDate(), getPaymentType(), getBankCardInfo(), getOtherInformation());
        }
    }
}
