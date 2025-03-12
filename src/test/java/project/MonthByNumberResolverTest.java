package Java_project_budget;

import Java_project_budget.model.enums.Months;
import Java_project_budget.model.input.utils.MonthByNumberResolver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class MonthByNumberResolverTest {

    @Test
    void testMonthByNumberShouldReturnValidResult() {
        //when
        final Months month = MonthByNumberResolver.getMonthByNumber(12);

        //then
        assertEquals(Months.GRUODIS, month);
    }

    @Test
    void testMonthByNumberShouldReturnInValidResult() {
        //when
        final Months month = MonthByNumberResolver.getMonthByNumber(15);

        //then
        assertNull(month);
    }
}
