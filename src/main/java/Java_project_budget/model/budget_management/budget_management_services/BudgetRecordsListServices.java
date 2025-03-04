package Java_project_budget.model.budget_management.budget_management_services;

import Java_project_budget.model.budget_management.budget_management_utilities.BudgetRecordIndexById;
import Java_project_budget.model.data_classes.IncomeRecord;
import Java_project_budget.model.data_classes.abstract_classes.BudgetRecord;
import Java_project_budget.model.user_input_validators.abstract_validators.RecordIdValidator;
import java.util.List;

public final class BudgetRecordsListServices {

    public void addBudgetRecord(List<BudgetRecord> budgetRecordsList, BudgetRecord budgetRecord) {
        budgetRecordsList.add(budgetRecord);

        if (budgetRecord instanceof IncomeRecord) {
            System.out.println("\nPajamų įrašas buvo sėkmingai pridėtas.\n");
        } else {
            System.out.println("\nIšlaidų įrašas buvo sėkmingai pridėtas.\n");
        }
    }

    public void removeBudgetRecord(List<BudgetRecord> budgetRecordsList,
                                          RecordIdValidator recordIdValidator) {
        int budgetRecordIndex = BudgetRecordIndexById.getBudgetRecordIndex(budgetRecordsList,
                recordIdValidator.enterId());

        if (budgetRecordIndex != -1) {
            budgetRecordsList.remove(budgetRecordsList.get(budgetRecordIndex));

            System.out.println(budgetRecordsList.get(budgetRecordIndex) instanceof IncomeRecord ?
                    "\nPasirinktas pajamų įrašas buvo sėkmingai pašalintas.\n" :
                    "\nPasirinktas išlaidų įrašas buvo sėkmingai pašalintas.\n");
        } else {
            System.out.println("\nJūsų nurodytas unikalus įrašo numeris neegzistuoja!\n");
        }
    }
}
