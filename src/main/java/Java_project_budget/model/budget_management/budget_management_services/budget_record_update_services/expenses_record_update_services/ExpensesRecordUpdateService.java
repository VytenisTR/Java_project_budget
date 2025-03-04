package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.expenses_record_update_services;

import Java_project_budget.model.data_classes.ExpensesRecord;

public final class ExpensesRecordUpdateService {
    private final ExpensesAmountUpdateService expensesAmountUpdateService = new ExpensesAmountUpdateService();
    private final ExpensesBankCardUpdateService expensesBankCardUpdateService = new ExpensesBankCardUpdateService();
    private final ExpensesCategoryUpdateService expensesCategoryUpdateService = new ExpensesCategoryUpdateService();
    private final ExpensesDateUpdateService expensesDateUpdateService = new ExpensesDateUpdateService();
    private final ExpensesOtherInformationUpdateService expensesOtherInformationUpdateService = new ExpensesOtherInformationUpdateService();
    private final ExpensesPaymentTypeUpdateService expensesPaymentTypeUpdateService = new ExpensesPaymentTypeUpdateService();

    public void updateExpensesRecord(ExpensesRecord expensesRecord) {
        if (expensesRecord.getBankCardInfo() == null) {
            expensesAmountUpdateService.updateExpensesAmount(expensesRecord);
            expensesCategoryUpdateService.updateExpensesCategory(expensesRecord);
            expensesDateUpdateService.updateExpensesDate(expensesRecord);
            expensesPaymentTypeUpdateService.updateExpensesPaymentType(expensesRecord);
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
