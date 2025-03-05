package Java_project_budget.model.budget_management.budget_management_services;

import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.abstract_validators.RecordAmountValidator;
import Java_project_budget.model.user_input_validators.common_validators.OtherInformationValidator;
import Java_project_budget.model.user_input_validators.common_validators.date_time_validator.DateTimeValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeAmountValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeCategoryValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeIsBankTransferValidator;

public final class IncomeRecordResolverService {
    private final RecordAmountValidator recordAmountValidator = new IncomeAmountValidator();
    private final IncomeCategoryValidator incomeCategoryValidator = new IncomeCategoryValidator();
    private final DateTimeValidator dateTimeValidator = new DateTimeValidator();
    private final IncomeIsBankTransferValidator incomeIsBankTransferValidator = new IncomeIsBankTransferValidator();
    private final OtherInformationValidator otherInformationValidator = new OtherInformationValidator();

    public IncomeRecord createIncomeRecord() {
        return new IncomeRecord(recordAmountValidator.enterAmount(),
                incomeCategoryValidator.enterIncomeCategory(),
                dateTimeValidator.enterDateTime(),
                incomeIsBankTransferValidator.isBankTransfer(),
                otherInformationValidator.enterOtherInformation());
    }
}
