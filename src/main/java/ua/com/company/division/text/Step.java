package ua.com.company.division.text;

import java.util.Objects;

public class Step {
    private final int dividend;
    private final int division;
    private final boolean last;

    public Step(int division, int dividend) {
        this.dividend = dividend;
        this.division = division;
        last = false;
    }

    public Step(int division) {
        this.division = division;
        this.dividend = 0;
        last = true;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivision() {
        return division;
    }

    public boolean isLast() {
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return dividend == step.dividend && division == step.division && last == step.last;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, division, last);
    }
}
