package ua.com.company.division.text;

import ua.com.company.division.model.Result;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringJoiner;

public class Formatter {

    Properties properties = new Properties();

    public String format(Result result) throws IOException {
        var head = buildHead(result);
        var body = buildBody(result, head);
        return body.toString();
    }

    private StringJoiner buildHead(Result result) throws IOException {
        try (FileInputStream in = new FileInputStream("src/main/resources/VarChar.txt")) {
            properties.load(in);
            var space = properties.getProperty("space");
            var dash = properties.getProperty("dash");
            var verticalBar = properties.getProperty("verticalBar");
            var underscore = properties.getProperty("underscore");
            var output = new StringJoiner("\n");
            var dividend = result.getDividend();
            if (!result.getStepList().get(0).isLast()) {
                dividend = result.getStepList().get(0).getDividend();
            }
            var removal = String.valueOf(result.getStepList().get(0).getDivision()).length() -
                    String.valueOf(result.getStepList().get(0).getDividend()).length() + 1;
            if (result.getDividend() < 0) {
                removal++;
            }
            output.add(underscore + result.getDividend() + verticalBar + result.getDivisor());
            output.add(addChar(removal, space) + dividend + addChar(String.valueOf(result.getDividend()).length() - removal -
                    String.valueOf(dividend).length() + 1, space)
                    + verticalBar + addChar(Math.max(String.valueOf(result.getResult()).length(), String.valueOf(result.getDivisor()).length()), dash));
            output.add(addChar(removal, space) + addChar(String.valueOf(dividend).length(), dash)
                    + addChar(String.valueOf(result.getDividend()).length() - removal - String.valueOf(dividend).length() + 1, space) +
                    verticalBar + result.getResult());
            return output;
        }
    }

    private StringJoiner buildBody(Result result, StringJoiner output) throws IOException {
        try (FileInputStream in = new FileInputStream("src/main/resources/VarChar.txt")) {
            properties.load(in);
            var space = properties.getProperty("space");
            var dash = properties.getProperty("dash");
            var removal = String.valueOf(result.getStepList().get(0).getDivision()).length() -
                    String.valueOf(result.getStepList().get(0).getDividend()).length() + 1;
            if (result.getDividend() < 0) {
                removal++;
            }
            for (int i = 1; i < result.getStepList().size(); i++) {
                var dividend = result.getStepList().get(i - 1).getDividend();
                var division = result.getStepList().get(i - 1).getDivision();
                var difference = division - dividend;
                if (difference == 0 && !result.getStepList().get(i).isLast()) {
                    removal = removal + String.valueOf(division).length() - String.valueOf(difference).length() + 1;
                } else {
                    removal = removal + String.valueOf(dividend).length() - String.valueOf(difference).length();
                }
                if (result.getStepList().get(i).isLast()) {
                    output.add(addChar(removal, space) + result.getStepList().get(i).getDivision());
                } else {
                    output.add(addChar(removal, space) + result.getStepList().get(i).getDivision());
                    if (String.valueOf(result.getStepList().get(i).getDivision()).length() >
                            String.valueOf(result.getStepList().get(i).getDividend()).length()) {
                        removal++;
                    }
                    output.add(addChar(removal, space) + result.getStepList().get(i).getDividend());
                    output.add(addChar(removal, space) +
                            addChar(String.valueOf(result.getStepList().get(i).getDividend()).length(), dash));
                }
            }
            return output;
        }
    }

    private String addChar(int times, String character) {
        return String.valueOf(character).repeat(Math.max(0, times));
    }

}
