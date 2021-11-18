package ua.com.company.division.math;

import ua.com.company.division.model.Result;
import ua.com.company.division.text.Step;

import java.util.ArrayList;


public class Divider {

    public Result divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Divisor can't be a 0");
        }

        int result = dividend / divisor;
        Result divisionResult = new Result(dividend, divisor,result);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        String dividendString = String.valueOf(dividend);
        int currentNumber = getLeftDigit(dividendString);
        dividendString = destroyLeftDigit(dividendString);
        ArrayList<Step> stepList = new ArrayList<>();
        do {
            dividend = dividendStringToInt(dividend, dividendString);
            if (currentNumber < divisor) {

                if (dividendString.length() > 0) {
                    currentNumber = currentNumber * 10 + getLeftDigit(dividendString);
                    dividendString = destroyLeftDigit(dividendString);

                    if (currentNumber==0 && dividend!=0){
                        stepList.add(new Step(currentNumber,currentNumber));
                        dividendString=destroyLeftDigit(dividendString);
                        currentNumber = getLeftDigit(dividendString);
                    }
                }

                else {
                    stepList.add(new Step(currentNumber));
                    currentNumber = 0;
                }
            } else {
                stepList.add(new Step(currentNumber, currentNumber - currentNumber % divisor));
                currentNumber = currentNumber % divisor;
            }


        }
        while (dividendString.length() > 0 || currentNumber > 0 || !stepList.get(stepList.size() - 1).isLast());
        divisionResult.setStepList(stepList);
        return divisionResult;

    }

    private int getLeftDigit(String digit) {
        return Integer.parseInt(String.valueOf(digit.toCharArray()[0]));
    }

    private String destroyLeftDigit(String digit) {
        return digit.substring(1);
    }

    private int dividendStringToInt(int dividend, String dividendString) {
        if (dividendString.length() > 0) {
            return Integer.parseInt(dividendString);
        } else {
            return dividend;
        }
    }
}
