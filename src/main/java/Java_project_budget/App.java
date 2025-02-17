package Java_project_budget;

import Java_project_budget.BudgetEnums.CardType;
import Java_project_budget.BudgetEnums.ExpensesCategory;
import Java_project_budget.BudgetEnums.IncomeCategory;
import Java_project_budget.BudgetEnums.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class App {

    public static void main(String[] args) {
        BudgetService budget = new BudgetService();

        budget.addIncomeRecord(new IncomeRecord(BigDecimal.valueOf(1500), IncomeCategory.DARBO_UŽMOKESTIS,
                LocalDateTime.now(), true, null));
        budget.addIncomeRecord(new IncomeRecord(BigDecimal.valueOf(500), IncomeCategory.PRIEDAI,
                LocalDateTime.now(), true, "Priedas prie darbo užmokesčio."));
        budget.addExpensesRecord(new ExpensesRecord(BigDecimal.valueOf(300),
                ExpensesCategory.KOMUNALINIAI_MOKESČIAI, LocalDateTime.now(),
                PaymentType.BANKINIS_PAVEDIMAS,
                new BankCard("9820 3450 4440 5741 5426", CardType.DEBETINĖ), null));
        budget.addExpensesRecord(new ExpensesRecord(BigDecimal.valueOf(100),
                ExpensesCategory.KURAS, LocalDateTime.now(),
                PaymentType.GRYNIEJI, "Kuras."));
        budget.getIncomeRecordList();
        budget.getExpensesRecordList();
    }
}