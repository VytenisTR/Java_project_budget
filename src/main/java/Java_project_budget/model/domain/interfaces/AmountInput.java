package Java_project_budget.model.domain.interfaces;

import java.math.BigDecimal;

public interface AmountInput extends ScannerInput{

    BigDecimal enterAmount();
}
