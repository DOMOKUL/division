package ua.com.company.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.com.company.division.math.Divider;
import ua.com.company.division.model.Result;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class FormatterTest {

    private Formatter formatter;
    private Result result;

    @Mock
    private Divider divider;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoInteger() throws IOException {
        result = new Result(78454,4,19613, List.of(
                new Step(7, 4 ),
                new Step(38,36),
                new Step(24,24),
                new Step(5,4),
                new Step(14,12),
                new Step(2)
                ));
        Mockito.when(divider.divide(78454,4)).thenReturn(result);
        String expected = "_78454|4" + "\n" +
                " 4    |-----" + "\n" +
                " -    |19613" + "\n" +
                " 38" + "\n" +
                " 36" + "\n" +
                " --" + "\n" +
                "  24" + "\n" +
                "  24" + "\n" +
                "  --" + "\n" +
                "    5" + "\n" +
                "    4" + "\n" +
                "    -" + "\n" +
                "    14" + "\n" +
                "    12" + "\n" +
                "    --" + "\n" +
                "     2";
        String actual = formatter.format(divider.divide(78454,4));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoLargeInteger() throws IOException {
        result = new Result(630440,610,1033, List.of(
                new Step(630, 610 ),
                new Step(2044,1830),
                new Step(2140,1830),
                new Step(310)
        ));
        Mockito.when(divider.divide(630440,610)).thenReturn(result);
        String expected =
                "_630440|610" + "\n" +
                        " 610   |----" + "\n" +
                        " ---   |1033" + "\n" +
                        "  2044" + "\n" +
                        "  1830" + "\n" +
                        "  ----" + "\n" +
                        "   2140" + "\n" +
                        "   1830" + "\n" +
                        "   ----" + "\n" +
                        "    310";
        String actual = formatter.format(divider.divide(630440, 610));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputCarryOverRemainder() throws IOException {
        result = new Result(12350000,1234,10008, List.of(
                new Step(1235, 1234 ),
                new Step(10000,9872),
                new Step(128)
        ));
        Mockito.when(divider.divide(12350000,1234)).thenReturn(result);
        String expected =
                        "_12350000|1234" + "\n" +
                        " 1234    |-----" + "\n" +
                        " ----    |10008" + "\n" +
                        "    10000" + "\n" +
                        "     9872" + "\n" +
                        "     ----" + "\n" +
                        "      128";
        String actual = formatter.format(divider.divide(12350000, 1234));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenDivideIntegerByOne() throws IOException {
        result = new Result(12341234,1,12341234, List.of(
                new Step(1, 1 ),
                new Step(2,2),
                new Step(3,3),
                new Step(4,4),
                new Step(1,1),
                new Step(2,2),
                new Step(3,3),
                new Step(4,4),
                new Step(0)
        ));
        Mockito.when(divider.divide(12341234,1)).thenReturn(result);
        String expected =
                        "_12341234|1" + "\n" +
                        " 1       |--------" + "\n" +
                        " -       |12341234" + "\n" +
                        "  2" + "\n" +
                        "  2" + "\n" +
                        "  -" + "\n" +
                        "   3" + "\n" +
                        "   3" + "\n" +
                        "   -" + "\n" +
                        "    4" + "\n" +
                        "    4" + "\n" +
                        "    -" + "\n" +
                        "     1" + "\n" +
                        "     1" + "\n" +
                        "     -" + "\n" +
                        "      2" + "\n" +
                        "      2" + "\n" +
                        "      -" + "\n" +
                        "       3" + "\n" +
                        "       3" + "\n" +
                        "       -" + "\n" +
                        "        4" + "\n" +
                        "        4" + "\n" +
                        "        -" + "\n" +
                        "        0";
        String actual = formatter.format(divider.divide(12341234, 1));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBarWithNegativeResult_whenDivideNegativeByInteger() throws IOException {
        result = new Result(-150,9,-16, List.of(
                new Step(15, 9),
                new Step(60,54),
                new Step(6)
        ));
        Mockito.when(divider.divide(-150,9)).thenReturn(result);
        String expected =
                        "_-150|9" + "\n" +
                        "   9 |---" + "\n" +
                        "   - |-16" + "\n" +
                        "   60" + "\n" +
                        "   54" + "\n" +
                        "   --" + "\n" +
                        "    6";
        String actual = formatter.format(divider.divide(-150, 9));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBarWithPositiveResult_whenDividePositiveByPositive() throws IOException {
        result = new Result(405022500,45,9000500, List.of(
                new Step(405, 405),
                new Step(0,0),
                new Step(225,225),
                new Step(0)
        ));
        Mockito.when(divider.divide(405022500,45)).thenReturn(result);
        String expected =
                "_405022500|45" + "\n" +
                " 405      |-------" + "\n" +
                " ---      |9000500" + "\n" +
                "    0" + "\n" +
                "    0" + "\n" +
                "    -" + "\n" +
                "     225" + "\n" +
                "     225" + "\n" +
                "     ---" + "\n" +
                "       0";
        String actual = formatter.format(divider.divide(405022500, 45));
        assertEquals(expected, actual);
    }
}