package project.domain.interfaces;

import java.math.BigDecimal;

public interface AmountInput extends ScannerInput{

    BigDecimal enterAmount();
}
