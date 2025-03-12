package project.budget.services;

import project.domain.data.IncomeRecord;
import project.domain.interfaces.AmountInput;
import project.input.income.IncomeOtherInformationInput;
import project.input.income.IncomeAmountInput;
import project.input.income.IncomeCategoryInput;
import project.input.income.IncomeIsBankTransferInput;
import project.input.income.date.IncomeDateTimeInput;

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
