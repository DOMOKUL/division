package ua.com.company.division.math;

import org.junit.jupiter.api.*;
import ua.com.company.division.model.Result;
import ua.com.company.division.text.Step;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DividerTest {
    private Divider divider;

    @BeforeEach
    void setUp() {
        divider = new Divider();
    }

    @Test
    void divideInteger_shouldNotHaveStep_whenDivideZeroByInteger() {
        Result result = new Result(0, 156, 0);
        Result actualResult = divider.divide(0, 156);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(0));
        result.setStepList(stepList);
        assertEquals(result.toString(), actualResult.toString());
    }

    @Test
    void divideInteger_shouldReturnResultEqualToDividend_whenDivideIntegerByOne() {
        Result result = new Result(12341234, 1, 12341234);
        Result actualResult = divider.divide(12341234, 1);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(1, 1));
        stepList.add(new Step(2, 2));
        stepList.add(new Step(3,3));
        stepList.add(new Step(4,4));
        stepList.add(new Step(1,1));
        stepList.add(new Step(2,2));
        stepList.add(new Step(3,3));
        stepList.add(new Step(4,4));
        stepList.add(new Step(0));
        result.setStepList(stepList);
        assertEquals(result, actualResult);
    }

    @Test
    void divideInteger_shouldReturnNegativeResult_whenDivideNegativeByInteger() {
        Result result = new Result(-78, 10, -7);
        Result actual = divider.divide(-78, 10);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(78, 70));
        stepList.add(new Step(8));
        result.setStepList(stepList);
        assertEquals(result, actual);
    }

    @Test
    void divideInteger_shouldReturnPositiveResult_whenDivideNegativeByNegative() {
        Result result = new Result(-150, -7, 21);
        Result actual = divider.divide(-150, -7);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(15, 14));
        stepList.add(new Step(10, 7));
        stepList.add(new Step(3));
        result.setStepList(stepList);
        assertEquals(result, actual);
    }

    @Test
    void divideInteger_shouldNotReturnResult_whenIntegerDivideByZero() {
        String excepted = "Divisor can't be an 0";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            divider.divide(78454, 0);
        });
        String actual = exception.getMessage();
        assertTrue(actual.contains(excepted));
    }

    @Test
    void divideInteger_shouldReturnRemainderEquals0_whenDividendEqualsToDivisor(){
        Result result = new Result(630440,630440,1);
        Result actual = divider.divide(630440,630440);
        ArrayList<Step> stepList = new ArrayList<>();
        stepList.add(new Step(630440,630440));
        stepList.add(new Step(0));
        result.setStepList(stepList);
        assertEquals(result,actual);
    }

}