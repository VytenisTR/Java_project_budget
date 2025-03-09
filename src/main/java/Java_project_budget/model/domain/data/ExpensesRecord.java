package Java_project_budget.model.domain.data;

import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.enums.ExpensesCategory;
import Java_project_budget.model.enums.PaymentType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ExpensesRecord extends BudgetRecord implements Serializable {
    private ExpensesCategory category;
    private PaymentType paymentType;
    private BankCard bankCard;

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category,
                          final LocalDateTime date, final PaymentType paymentType,
                          final BankCard bankCard, final String otherInformation) {
        super(amount, date, otherInformation);
        this.category = category;
        this.paymentType = paymentType;
        this.bankCard = bankCard;
        super.increaseIdCount();
    }

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category,
                          final LocalDateTime date, final PaymentType paymentType,
                          final String otherInformation) {
        super(amount, date, otherInformation);
        this.category = category;
        this.paymentType = paymentType;
        super.increaseIdCount();
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    public ExpensesCategory getCategory() {
        return category;
    }

    public String getDate() {
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(dateTimeFormatter);
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public String getOtherInformation() {
        if (otherInformation.isBlank())
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
    }

    public void setAmount(final BigDecimal amount) {
        this.amount = amount;
    }

    public void setCategory(final ExpensesCategory category) {
        this.category = category;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }

    public void setPaymentType(final PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public void setBankCardInfo(final BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void setOtherInformation(final String otherInformation) {
        this.otherInformation = otherInformation;
    }

    @Override
    public String toString() {
        if (paymentType == PaymentType.GRYNIEJI) {
            return String.format("\nUnikalus išlaidų įrašo numeris: %d\n" +
                            "Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "Papildoma informacija: %s", getId(), getAmount(), getCategory().getPrintLT(),
                    getDate(), getPaymentType().getPrintLT(), getOtherInformation());
        } else {
            return String.format("\nUnikalus išlaidų įrašo numeris: %d\n" +
                            "Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "Banko kortelės numeris: %s\n" +
                            "Banko kortelės tipas: %s\n" +
                            "Papildoma informacija: %s", getId(), getAmount(), getCategory().getPrintLT(),
                    getDate(), getPaymentType().getPrintLT(), getBankCard().getNumber(),
                    getBankCard().getCardType().getPrintLT(), getOtherInformation());
        }
    }
}
