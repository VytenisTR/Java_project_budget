package Java_project_budget.model.user_input_validators.abstract_validators;

import java.util.Scanner;

public abstract class RecordIdValidator {
    protected static final Scanner SC = new Scanner(System.in);

    public abstract int enterId();
}
