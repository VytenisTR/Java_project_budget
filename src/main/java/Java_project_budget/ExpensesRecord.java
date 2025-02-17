package Java_project_budget;

import Java_project_budget.BudgetEnums.ExpensesCategory;
import Java_project_budget.BudgetEnums.PaymentType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExpensesRecord {
    private final BigDecimal amount;
    private final ExpensesCategory category;
    private final LocalDateTime date;
    private final PaymentType paymentType;
    private final BankCard bankCard;
    private final String otherInformation;

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category, final LocalDateTime date
            , final PaymentType paymentType, final BankCard bankCard, final String otherInformation) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.paymentType = paymentType;
        this.bankCard = bankCard;
        if (otherInformation == null)
            this.otherInformation = otherInformation;
        else
            this.otherInformation = (otherInformation.substring(0, 1).toUpperCase()
                    + otherInformation.substring(1).toLowerCase()).trim();
    }

    public ExpensesRecord(final BigDecimal amount, final ExpensesCategory category, final LocalDateTime date
            , final PaymentType paymentType, final String otherInformation) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.paymentType = paymentType;
        this.bankCard = null;
        if (otherInformation == null)
            this.otherInformation = otherInformation;
        else
            this.otherInformation = (otherInformation.substring(0, 1).toUpperCase()
                    + otherInformation.substring(1).toLowerCase()).trim();
    }

    public double getAmount() {
        return amount.doubleValue();
    }

    public String getCategory() {
        return (category.toString().substring(0, 1).toUpperCase()
                + category.toString().substring(1).toLowerCase())
                .replace('_', ' ');
    }

    public String getDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:SS");
        return date.format(dateTimeFormatter);
    }

    public String getPaymentType() {
        return (paymentType.toString().substring(0, 1).toUpperCase()
                + paymentType.toString().substring(1).toLowerCase())
                .replace('_', ' ');
    }

    public String getBankCardInfo() {
        return bankCard.toString();
    }

    public String getOtherInformation() {
        if (otherInformation == null)
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
    }

    @Override
    public String toString() {
        if (bankCard == null) {
            return String.format("Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "Papildoma informacija: %s\n", getAmount(), getCategory(),
                    getDate(), getPaymentType(), getOtherInformation());
        } else {
            return String.format("Išlaidų suma: %.2f EUR\n" +
                            "Išlaidų kategorija: %s\n" +
                            "Išlaidų įrašo data: %s\n" +
                            "Atsiskaitymo būdas: %s\n" +
                            "%s" + //Banko kortelės informacija
                            "Papildoma informacija: %s\n", getAmount(), getCategory(),
                    getDate(), getPaymentType(), getBankCardInfo(), getOtherInformation());
        }
    }
}
