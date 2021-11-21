package ua.com.company.division;

import ua.com.company.division.math.Divider;
import ua.com.company.division.model.Result;
import ua.com.company.division.text.Formatter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var dividend = Integer.parseInt(args[0]);
        var divisor = Integer.parseInt(args[1]);
        Divider divider = new Divider();
        Result result = divider.divide(dividend, divisor);
        Formatter formatter = new Formatter();
        System.out.print(formatter.format(result));
    }
}