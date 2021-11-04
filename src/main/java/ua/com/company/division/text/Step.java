package ua.com.company.division.text;

import java.util.Objects;

public class Step {
    private final int dividen;
    private final int division;
    private final boolean last;

    public Step(int division, int dividend) {
        this.dividen = dividend;
        this.division = division;
        last = false;
    }

    public Step(int division) {
        this.division = division;
        dividen = 0;
        last = true;
    }

    public int getDividend() {
        return dividen;
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
        return dividen == step.dividen && division == step.division && last == step.last;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividen, division, last);
    }
}
