package Java_project_budget.model.data_classes;

import Java_project_budget.model.enums.IncomeCategory;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IncomeRecord {
    private long idCount = 1;
    private final long id;
    private final BigDecimal amount;
    private final IncomeCategory category;
    private final LocalDateTime date;
    private final boolean isBankTransfer;
    private final String otherInformation;

    public IncomeRecord(final BigDecimal amount, final IncomeCategory category, final LocalDateTime date,
                        boolean isBankTransfer, final String otherInformation) {
        this.id = idCount;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.isBankTransfer = isBankTransfer;
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

    public String getIsBankTransfer() {
        if (isBankTransfer)
            return "Pinigai buvo gauti į banko sąskaitą.";
        else
            return "Pinigai nebuvo gauti į banko sąskaitą.";
    }

    public String getOtherInformation() {
        if (otherInformation.isBlank())
            return "Nėra jokios papildomos informacijos.";
        else
            return otherInformation;
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
