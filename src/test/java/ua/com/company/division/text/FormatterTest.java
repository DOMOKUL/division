package ua.com.company.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.company.division.math.Divider;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    private Formatter formatter;
    private Divider divider;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();
        divider = new Divider();
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoInteger() {
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
        String actual = formatter.format(divider.divide(78454, 4));
        assertEquals(expected, actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoLargeInteger() {
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
    void formatResult_shouldReturnDivisionBar_whenInputCarryOverRemainder() {
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
    void formatResult_shouldReturnDivisionBar_whenDivideIntegerByOne() {
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
    void formatResult_shouldReturnDivisionBarWithNegativeResult_whenDivideNegativeByInteger() {
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
    void formatResult_shouldReturnDivisionBarWithPositiveResult_whenDividePositiveByPositive() {
        String expected = "_405022500|45" + "\n" +
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