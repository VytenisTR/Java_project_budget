package Java_project_budget.model.data_classes.abstract_classes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class BudgetRecord {
    private long idCount = 1;
    protected final long id;
    protected BigDecimal amount;
    protected LocalDateTime date;
    protected String otherInformation;

    protected BudgetRecord(final BigDecimal amount, final LocalDateTime date, final String otherInformation) {
        this.id = idCount;
        this.amount = amount;
        this.date = date;
        this.otherInformation = otherInformation;
    }

    protected void increaseIdCount() {
        this.idCount++;
    }

    public abstract long getId();

    public abstract double getAmount();

    public abstract String getDate();

    public abstract String getOtherInformation();

    public abstract void setAmount(BigDecimal amount);

    public abstract void setDate(LocalDateTime date);

    public abstract void setOtherInformation(String otherInformation);
}
