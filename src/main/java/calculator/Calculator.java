package calculator;

import calculator.util.NumberConverter;

public class Calculator {
    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int calculate(String input) {
        String[] tokens = parser.parse(input);
        int[] numbers = NumberConverter.convert(tokens);
        return sum(numbers);
    }

    private int sum(int[] numbers) {
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        return result;
    }
}
