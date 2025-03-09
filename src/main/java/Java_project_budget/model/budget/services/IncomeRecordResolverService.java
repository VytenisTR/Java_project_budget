package Java_project_budget.model.budget.services;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.interfaces.AmountInput;
import Java_project_budget.model.input.income.IncomeOtherInformationInput;
import Java_project_budget.model.input.income.IncomeAmountInput;
import Java_project_budget.model.input.income.IncomeCategoryInput;
import Java_project_budget.model.input.income.IncomeIsBankTransferInput;
import Java_project_budget.model.input.income.date.IncomeDateTimeInput;

public final class IncomeRecordResolverService {
    private final AmountInput amountInput = new IncomeAmountInput();
    private final IncomeCategoryInput incomeCategoryInput = new IncomeCategoryInput();
    private final IncomeDateTimeInput incomeDateTimeInput = new IncomeDateTimeInput();
    private final IncomeIsBankTransferInput incomeIsBankTransferInput = new IncomeIsBankTransferInput();
    private final IncomeOtherInformationInput incomeOtherInformationInput = new IncomeOtherInformationInput();

    public IncomeRecord createIncomeRecord() {
        return new IncomeRecord(amountInput.enterAmount(),
                incomeCategoryInput.enterIncomeCategory(),
                incomeDateTimeInput.enterDateTime(),
                incomeIsBankTransferInput.isBankTransfer(),
                incomeOtherInformationInput.enterOtherInformation());
    }
}
