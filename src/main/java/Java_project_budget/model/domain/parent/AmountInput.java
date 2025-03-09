package Java_project_budget.model.domain.parent;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class AmountInput {
    protected static final Scanner SC = new Scanner(System.in);

    public abstract BigDecimal enterAmount();
}
