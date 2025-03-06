package Java_project_budget.model.domain.data;

import Java_project_budget.model.domain.parent.BudgetRecord;
import Java_project_budget.model.enums.IncomeCategory;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class IncomeRecord extends BudgetRecord implements Serializable {
    private IncomeCategory category;
    private boolean isBankTransfer;

    public IncomeRecord(final BigDecimal amount, final IncomeCategory category, final LocalDateTime date,
                        boolean isBankTransfer, final String otherInformation) {
        super(amount, date, otherInformation);
        this.category = category;
        this.isBankTransfer = isBankTransfer;
        super.increaseIdCount();
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
        final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(dateTimeFormatter);
    }

    public String getIsBankTransfer() {
        if (isBankTransfer)
            return "Taip";
        else
            return "Ne";
    }

    public String getOtherInformation() {
        if (otherInformation.isBlank())
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
    }

    public void setAmount (final BigDecimal amount) {
        this.amount = amount;
    }

    public void setCategory (final IncomeCategory category) {
        this.category = category;
    }

    public void setDate (final LocalDateTime date) {
        this.date = date;
    }

    public void setIsBankTransfer(final boolean isBankTransfer) {
        this.isBankTransfer = isBankTransfer;
    }

    public void setOtherInformation(final String otherInformation) {
        this.otherInformation = otherInformation;
    }

    @Override
    public String toString() {
        return String.format("\nUnikalus pajamų įrašo numeris: %d\n" +
                "Pajamų suma: %.2f EUR\n" +
                "Pajamų kategorija: %s\n" +
                "Pajamų įrašo data: %s\n" +
                "Ar pajamos buvo gautos į banko sąskaitą: %s\n" +
                "Papildoma informacija: %s", getId(), getAmount(), getCategory(),
                getDate(), isBankTransfer ? "Taip" : "Ne", getOtherInformation());
    }
}
