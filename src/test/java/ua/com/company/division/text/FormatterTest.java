package ua.com.company.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.company.division.model.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {

    private Formatter formatter;
    private Result result;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();

    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoInteger() throws IOException {
        // arrange
        result = new Result(78454, 4, 19613, List.of(
                new Step(7, 4),
                new Step(38, 36),
                new Step(24, 24),
                new Step(5, 4),
                new Step(14, 12),
                new Step(2)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/TwoInteger.txt"), String.valueOf(actual));
    }


    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoLargeInteger() throws IOException {
        // arrange
        result = new Result(630440, 610, 1033, List.of(
                new Step(630, 610),
                new Step(2044, 1830),
                new Step(2140, 1830),
                new Step(310)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/TwoLargeInteger.txt"), actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputCarryOverRemainder() throws IOException {
        // arrange
        result = new Result(12350000, 1234, 10008, List.of(
                new Step(1235, 1234),
                new Step(10000, 9872),
                new Step(128)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/InputCarryOverRemainder.txt"), actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenDivideIntegerByOne() throws IOException {
        // arrange
        result = new Result(12341234, 1, 12341234, List.of(
                new Step(1, 1),
                new Step(2, 2),
                new Step(3, 3),
                new Step(4, 4),
                new Step(1, 1),
                new Step(2, 2),
                new Step(3, 3),
                new Step(4, 4),
                new Step(0)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/DivideIntegerByOne.txt"), actual);
    }

    @Test
    void formatResult_shouldReturnDivisionBarWithNegativeResult_whenDivideNegativeByInteger() throws IOException {
        // arrange
        result = new Result(-150, 9, -16, List.of(
                new Step(15, 9),
                new Step(60, 54),
                new Step(6)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/DivideNegativeByInteger.txt"), actual);
    }


    @Test
    void formatResult_shouldReturnDivisionBarWithPositiveResult_whenDividePositiveByPositive() throws IOException {
        // arrange
        result = new Result(405022500, 45, 9000500, List.of(
                new Step(405, 405),
                new Step(0, 0),
                new Step(225, 225),
                new Step(0)
        ));

        // act
        String actual = formatter.format(result);

        // assert
        assertEquals(getExpectedResult("src/test/resources/DividePositiveByPositive.txt"), actual);
    }


    private String getExpectedResult(String filePath) {
        StringJoiner expected = new StringJoiner("\n");
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            expected.add(line);
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                expected.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expected.toString();
    }
}