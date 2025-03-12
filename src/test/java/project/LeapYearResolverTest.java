package project;

import project.input.utils.LeapYearResolver;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public final class LeapYearResolverTest {

    @Test
    void testIsLeapYearShouldReturnTrue() {
        //when
        final boolean isLeapYear = LeapYearResolver.isLeapYear(2024);

        //then
        assertTrue(isLeapYear);
    }

    @Test
    void testIsLeapYearShouldReturnFalse() {
        //when
        final boolean isLeapYear = LeapYearResolver.isLeapYear(2023);

        //then
        assertFalse(isLeapYear);
    }
}
