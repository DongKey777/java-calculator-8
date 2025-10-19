package calculator;

import calculator.util.NumberValidator;
import java.util.Arrays;

public class Calculator {
    private final Parser parser;

    public Calculator(Parser parser) {
        this.parser = parser;
    }

    public int calculate(String input) {
        String[] tokens = parser.parse(input);
        int[] numbers = toNumbers(tokens);
        return sum(numbers);
    }

    private int sum(int[] numbers) {
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        return result;
    }

    private int[] toNumbers(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(token -> !token.trim().isEmpty())
                .mapToInt(this::parseNumber)
                .toArray();
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            NumberValidator.validate(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력 불가능" + token);
        }
    }
}
