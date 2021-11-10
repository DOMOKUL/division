package ua.com.company.division.model;

import ua.com.company.division.text.Step;

import java.util.ArrayList;
import java.util.Objects;

public class Result {

    private final int dividend;
    private final int divisor;
    private final int outcome;
    private ArrayList<Step> stepList;

    public Result(int dividend, int divisor, int outcome) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.outcome = outcome;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getResult() {
        return outcome;
    }

    public ArrayList<Step> getStepList() {
        return stepList;
    }

    public void setStepList(ArrayList<Step> stepList) {
        this.stepList = stepList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return dividend == result.dividend && divisor == result.divisor && outcome == result.outcome && stepList.equals(result.stepList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, outcome, stepList);
    }

}
