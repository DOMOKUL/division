package ua.com.company.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.company.division.model.Result;
import ua.com.company.division.text.Step;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {

    private Divider divider;

    @BeforeEach
    void setUp() {
        divider = new Divider();
    }

    @Test
    void divideInteger_shouldNotHaveStep_whenDivideZeroByInteger() {
        Result expected = new Result(0, 156, 0);
        Result actual = divider.divide(0, 156);
        List<Step> stepList = List.of(new Step(0));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }

    @Test
    void divideInteger_shouldReturnResultEqualToDividend_whenDivideIntegerByOne() {
        Result expected = new Result(12341234, 1, 12341234);
        Result actual = divider.divide(12341234, 1);
        List<Step> stepList = List.of(new Step(1, 1),
                new Step(2, 2),
                new Step(3, 3),
                new Step(4, 4),
                new Step(1, 1),
                new Step(2, 2),
                new Step(3, 3),
                new Step(4, 4),
                new Step(0));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }

    @Test
    void divideInteger_shouldReturnNegativeResult_whenDivideNegativeByInteger() {
        Result expected = new Result(-78, 10, -7);
        Result actual = divider.divide(-78, 10);
        List<Step> stepList = List.of(new Step(78, 70),
                new Step(8));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }

    @Test
    void divideInteger_shouldReturnPositiveResult_whenDivideNegativeByNegative() {
        Result expected = new Result(-150, -7, 21);
        Result actual = divider.divide(-150, -7);
        List<Step> stepList = List.of(new Step(15, 14), new Step(10, 7), new Step(3));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }

    @Test
    void divideInteger_shouldNotReturnResult_whenIntegerDivideByZero() {
        String excepted = "Divisor can't be 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> divider.divide(78454, 0));
        String actual = exception.getMessage();
        assertTrue(actual.contains(excepted));
    }

    @Test
    void divideInteger_shouldReturnRemainderEquals0_whenDividendEqualsToDivisor() {
        Result expected = new Result(630440, 630440, 1);
        Result actual = divider.divide(630440, 630440);
        List<Step> stepList = List.of(new Step(630440, 630440),
                new Step(0));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }

    @Test
    void divideInteger_shouldReturnRightResult_whenDividendHaveZeros() {
        Result expected = new Result(405022500, 45, 9000500);
        Result actual = divider.divide(405022500, 45);
        List<Step> stepList = List.of(new Step(405, 405),
                new Step(0, 0),
                new Step(225, 225),
                new Step(0));
        expected.setStepList(stepList);
        assertEquals(expected, actual);
    }
}