package ua.com.company.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.company.division.model.Result;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FormatterTest {
    Properties properties = new Properties();
    private Formatter formatter;
    private Result result;

    @BeforeEach
    void setUp() {
        formatter = new Formatter();

    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoInteger() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/TwoInteger")) {
            properties.load(in);
            result = new Result(78454, 4, 19613, List.of(
                    new Step(7, 4),
                    new Step(38, 36),
                    new Step(24, 24),
                    new Step(5, 4),
                    new Step(14, 12),
                    new Step(2)
            ));
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, String.valueOf(actual));
        }
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputTwoLargeInteger() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/TwoLargeInteger")) {
            properties.load(in);
            result = new Result(630440, 610, 1033, List.of(
                    new Step(630, 610),
                    new Step(2044, 1830),
                    new Step(2140, 1830),
                    new Step(310)
            ));
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, actual);
        }
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenInputCarryOverRemainder() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/InputCarryOverRemainder")) {
            properties.load(in);
            result = new Result(12350000, 1234, 10008, List.of(
                    new Step(1235, 1234),
                    new Step(10000, 9872),
                    new Step(128)
            ));
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, actual);
        }
    }

    @Test
    void formatResult_shouldReturnDivisionBar_whenDivideIntegerByOne() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/DivideIntegerByOne")) {
            properties.load(in);
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
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, actual);
        }
    }

    @Test
    void formatResult_shouldReturnDivisionBarWithNegativeResult_whenDivideNegativeByInteger() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/DivideNegativeByInteger")) {
            properties.load(in);
            result = new Result(-150, 9, -16, List.of(
                    new Step(15, 9),
                    new Step(60, 54),
                    new Step(6)
            ));
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, actual);
        }
    }

    @Test
    void formatResult_shouldReturnDivisionBarWithPositiveResult_whenDividePositiveByPositive() throws IOException {
        // arrange
        try (FileInputStream in = new FileInputStream("src/test/resources/DividePositiveByPositive")) {
            properties.load(in);
            result = new Result(405022500, 45, 9000500, List.of(
                    new Step(405, 405),
                    new Step(0, 0),
                    new Step(225, 225),
                    new Step(0)
            ));
            var expected = properties.getProperty("expected");

            // act
            String actual = formatter.format(result);

            // assert
            assertEquals(expected, actual);
        }
    }
}