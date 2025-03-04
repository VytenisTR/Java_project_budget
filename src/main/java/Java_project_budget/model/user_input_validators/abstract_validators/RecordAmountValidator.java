package Java_project_budget.model.user_input_validators.abstract_validators;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class RecordAmountValidator {
    protected static final Scanner SC = new Scanner(System.in);

    public abstract BigDecimal enterAmount();
}
