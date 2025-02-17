package Java_project_budget;

import java.util.ArrayList;
import java.util.List;

public class BudgetService {
    private final List<IncomeRecord> incomeRecordList = new ArrayList<>();
    private final List<ExpensesRecord> expensesRecordList = new ArrayList<>();

    public void addIncomeRecord(IncomeRecord incomeRecord) {
        incomeRecordList.add(incomeRecord);
    }

    public void addExpensesRecord(ExpensesRecord expensesRecord) {
        expensesRecordList.add(expensesRecord);
    }

    public void getIncomeRecordList() {
        for (IncomeRecord incomeRecord : incomeRecordList) {
            System.out.println(incomeRecord);
        }
    }

    public void getExpensesRecordList() {
        for (ExpensesRecord expensesRecord : expensesRecordList) {
            System.out.println(expensesRecord);
        }
    }
}
