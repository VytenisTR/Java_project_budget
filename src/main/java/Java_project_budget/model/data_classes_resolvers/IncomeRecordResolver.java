package Java_project_budget.model.data_classes_resolvers;

import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.user_input_validators.common_validators.OtherInformationValidator;
import Java_project_budget.model.user_input_validators.common_validators.date_time_validator.DateTimeValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeAmountValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IncomeCategoryValidator;
import Java_project_budget.model.user_input_validators.income_record_validators.IsBankTransferValidator;

public final class IncomeRecordResolver {
    private final IncomeAmountValidator incomeAmountValidator = new IncomeAmountValidator();
    private final IncomeCategoryValidator incomeCategoryValidator = new IncomeCategoryValidator();
    private final DateTimeValidator dateTimeValidator = new DateTimeValidator();
    private final IsBankTransferValidator isBankTransferValidator = new IsBankTransferValidator();
    private final OtherInformationValidator otherInformationValidator = new OtherInformationValidator();

    public void createIncomeRecord() {
    }
}
