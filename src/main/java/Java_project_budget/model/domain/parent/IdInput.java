package Java_project_budget.model.domain.parent;

import java.util.Scanner;

public abstract class IdInput {
    protected static final Scanner SC = new Scanner(System.in);

    public abstract int enterId();
}
