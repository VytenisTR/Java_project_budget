package Java_project_budget.model.budget.services.update.expenses;

import Java_project_budget.model.domain.data.ExpensesRecord;

public final class ExpensesRecordUpdateService {
    private final ExpensesAmountUpdateService expensesAmountUpdateService = new ExpensesAmountUpdateService();
    private final ExpensesBankCardUpdateService expensesBankCardUpdateService = new ExpensesBankCardUpdateService();
    private final ExpensesCategoryUpdateService expensesCategoryUpdateService = new ExpensesCategoryUpdateService();
    private final ExpensesDateUpdateService expensesDateUpdateService = new ExpensesDateUpdateService();
    private final ExpensesOtherInformationUpdateService expensesOtherInformationUpdateService = new ExpensesOtherInformationUpdateService();
    private final ExpensesPaymentTypeUpdateService expensesPaymentTypeUpdateService = new ExpensesPaymentTypeUpdateService();

    public void updateExpensesRecord(ExpensesRecord expensesRecord) {
        if (expensesRecord.getPaymentType().getPrintLT().equals("Grynieji")) {
            expensesAmountUpdateService.updateExpensesAmount(expensesRecord);
            expensesCategoryUpdateService.updateExpensesCategory(expensesRecord);
            expensesDateUpdateService.updateExpensesDate(expensesRecord);
            expensesOtherInformationUpdateService.updateExpensesOtherInformation(expensesRecord);
        } else {
            expensesAmountUpdateService.updateExpensesAmount(expensesRecord);
            expensesCategoryUpdateService.updateExpensesCategory(expensesRecord);
            expensesDateUpdateService.updateExpensesDate(expensesRecord);
            expensesPaymentTypeUpdateService.updateExpensesPaymentType(expensesRecord);
            expensesBankCardUpdateService.updateExpensesBankCard(expensesRecord);
            expensesOtherInformationUpdateService.updateExpensesOtherInformation(expensesRecord);
        }
    }
}
