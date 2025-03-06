package Java_project_budget.model.budget.services;

import Java_project_budget.model.domain.data.IncomeRecord;
import Java_project_budget.model.domain.parent.AmountInput;
import Java_project_budget.model.input.common.OtherInformationInput;
import Java_project_budget.model.input.common.date.DateTimeInput;
import Java_project_budget.model.input.income.IncomeAmountInput;
import Java_project_budget.model.input.income.IncomeCategoryInput;
import Java_project_budget.model.input.income.IncomeIsBankTransferInput;

public final class IncomeRecordResolverService {
    private final AmountInput amountInput = new IncomeAmountInput();
    private final IncomeCategoryInput incomeCategoryInput = new IncomeCategoryInput();
    private final DateTimeInput dateTimeInput = new DateTimeInput();
    private final IncomeIsBankTransferInput incomeIsBankTransferInput = new IncomeIsBankTransferInput();
    private final OtherInformationInput otherInformationInput = new OtherInformationInput();

    public IncomeRecord createIncomeRecord() {
        return new IncomeRecord(amountInput.enterAmount(),
                incomeCategoryInput.enterIncomeCategory(),
                dateTimeInput.enterDateTime(),
                incomeIsBankTransferInput.isBankTransfer(),
                otherInformationInput.enterOtherInformation());
    }
}
