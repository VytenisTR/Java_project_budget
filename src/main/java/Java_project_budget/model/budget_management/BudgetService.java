package Java_project_budget.model.budget_management;

import Java_project_budget.model.data_classes.ExpensesRecord;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.meniu_selection.MeniuResolver;

import java.util.ArrayList;
import java.util.List;

public class BudgetService {
    private final List<IncomeRecord> incomeRecordList = new ArrayList<>();
    private final List<ExpensesRecord> expensesRecordList = new ArrayList<>();
    private final MeniuResolver meniuResolver = new MeniuResolver();

    /*public void runBudgetService() {
        switch (meniuResolver.resolveMeniu()) {
        }
    }

    private void addIncomeRecord(IncomeRecord incomeRecord) {
        incomeRecordList.add(incomeRecord);
    }

    private void addExpensesRecord(ExpensesRecord expensesRecord) {
        expensesRecordList.add(expensesRecord);
    }

    private void getIncomeRecordList() {
        for (IncomeRecord incomeRecord : incomeRecordList) {
            System.out.println(incomeRecord);
        }
    }

    private void removeIncomeRecord(long id) {
        incomeRecordList.remove((id - 1));
    }

    private void getExpensesRecordList() {
        for (ExpensesRecord expensesRecord : expensesRecordList) {
            System.out.println(expensesRecord);
        }
    }

    private void removeExpensesRecord(long id) {
        expensesRecordList.remove((id - 1));
    }

    private double balance() {
        double income = 0;
        double expenses = 0;

        for (IncomeRecord incomeRecord : incomeRecordList) {
            income += incomeRecord.getAmount();
        }

        for (ExpensesRecord expensesRecord : expensesRecordList) {
            expenses += expensesRecord.getAmount();
        }

        return (income - expenses);
    }*/
}
