package ua.com.company.division.text;

import ua.com.company.division.model.Result;

import java.util.StringJoiner;

public class Formatter {

    public String format(Result result) {
        var head = buildHead(result);
        var body = buildBody(result, head);
        return body.toString();
    }

    private StringJoiner buildHead(Result result) {
        var output = new StringJoiner("\n");
        int dividend = result.getDividend();
        if (!result.getStepList().get(0).isLast()) {
            dividend = result.getStepList().get(0).getDividend();
        }
        int removal = String.valueOf(result.getStepList().get(0).getDivision()).length() - String.valueOf(result.getStepList().get(0).getDividend()).length() + 1;
        if (result.getDividend() < 0) {
            removal++;
        }
        output.add("_" + result.getDividend() + "|" + result.getDivisor());
        output.add(addChar(removal, ' ') + dividend + addChar(String.valueOf(result.getDividend()).length() - removal - String.valueOf(dividend).length() + 1, ' ')
                + "|" + addChar(Math.max(String.valueOf(result.getResult()).length(), String.valueOf(result.getDivisor()).length()), '-'));
        output.add(addChar(removal, ' ') + addChar(String.valueOf(dividend).length(), '-')
                + addChar(String.valueOf(result.getDividend()).length() - removal - String.valueOf(dividend).length() + 1, ' ') + "|" + result.getResult());
        return output;

    }

    private StringJoiner buildBody(Result result, StringJoiner output) {
        int removal = String.valueOf(result.getStepList().get(0).getDivision()).length() - String.valueOf(result.getStepList().get(0).getDividend()).length() + 1;
        if (result.getDividend() < 0) {
            removal++;
        }
        for (int i = 1; i < result.getStepList().size(); i++) {
            int dividend = result.getStepList().get(i - 1).getDividend();
            int division = result.getStepList().get(i - 1).getDivision();
            int difference = division - dividend;
            if (difference == 0 && !result.getStepList().get(i).isLast()) {
                removal = removal + String.valueOf(division).length() - String.valueOf(difference).length() + 1;
            } else {
                removal = removal + String.valueOf(dividend).length() - String.valueOf(difference).length();
            }
            if (result.getStepList().get(i).isLast()) {
                output.add(addChar(removal, ' ') + result.getStepList().get(i).getDivision());
            } else {
                output.add(addChar(removal, ' ') + result.getStepList().get(i).getDivision());
                if (String.valueOf(result.getStepList().get(i).getDivision()).length() > String.valueOf(result.getStepList().get(i).getDividend()).length()) {
                    removal++;
                }
                output.add(addChar(removal, ' ') + result.getStepList().get(i).getDividend());
                output.add(addChar(removal, ' ') + addChar(String.valueOf(result.getStepList().get(i).getDividend()).length(), '-'));
            }
        }
        return output;
    }

    private String addChar(int times, char character) {
        var output = "";
        for (var i = 0; i < times; i++)
            output = output + character;
        return output;
    }

}
