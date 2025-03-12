package project.domain.interfaces;

import java.time.LocalDateTime;

public interface DateTimeInput extends ScannerInput{

    LocalDateTime enterDateTime();
}
