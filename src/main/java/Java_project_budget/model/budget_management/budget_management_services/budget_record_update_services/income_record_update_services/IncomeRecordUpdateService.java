package Java_project_budget.model.budget_management.budget_management_services.budget_record_update_services.income_record_update_services;

import Java_project_budget.model.data_classes.IncomeRecord;

public final class IncomeRecordUpdateService {
    private final IncomeAmountUpdateService incomeAmountUpdateService = new IncomeAmountUpdateService();
    private final IncomeCategoryUpdateService incomeCategoryUpdateService = new IncomeCategoryUpdateService();
    private final IncomeDateUpdateService incomeDateUpdateService = new IncomeDateUpdateService();
    private final IncomeIsBankTransferUpdateService incomeIsBankTransferUpdateService = new IncomeIsBankTransferUpdateService();
    private final IncomeOtherInformationUpdateService incomeOtherInformationUpdateService = new IncomeOtherInformationUpdateService();

    public void updateIncomeRecord(IncomeRecord incomeRecord) {
        incomeAmountUpdateService.updateIncomeAmount(incomeRecord);
        incomeCategoryUpdateService.updateIncomeCategory(incomeRecord);
        incomeDateUpdateService.updateIncomeDate(incomeRecord);
        incomeIsBankTransferUpdateService.updateIncomeIsBankTransfer(incomeRecord);
        incomeOtherInformationUpdateService.updateIncomeOtherInformation(incomeRecord);
    }
}
