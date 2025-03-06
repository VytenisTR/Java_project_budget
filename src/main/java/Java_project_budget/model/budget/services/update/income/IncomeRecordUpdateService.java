package Java_project_budget.model.budget.services.update.income;

import Java_project_budget.model.domain.data.IncomeRecord;

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
