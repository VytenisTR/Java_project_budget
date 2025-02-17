package Java_project_budget;

import Java_project_budget.BudgetEnums.IncomeCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncomeRecord {
    private final BigDecimal amount;
    private final IncomeCategory category;
    private final LocalDateTime date;
    private final boolean isBankTransfer;
    private final String otherInformation;

    public IncomeRecord(final BigDecimal amount, final IncomeCategory category, final LocalDateTime date
            , boolean isBankTransfer, final String otherInformation) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isBankTransfer = isBankTransfer;
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

    public String getIsBankTransfer() {
        if (isBankTransfer)
            return "Pinigai buvo gauti į banko sąskaitą.";
        else
            return "Pinigai nebuvo gauti į banko sąskaitą.";
    }

    public String getOtherInformation() {
        if (otherInformation == null)
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
    }

    @Override
    public String toString() {
        return String.format("Pajamų suma: %.2f EUR\n" +
                "Pajamų kategorija: %s\n" +
                "Pajamų įrašo data: %s\n" +
                "Ar pinigai buvo gauti į banko sąskaitą: %s\n" +
                "Papildoma informacija: %s\n", getAmount(), getCategory(),
                getDate(), isBankTransfer ? "Taip" : "Ne", getOtherInformation());
    }
}
