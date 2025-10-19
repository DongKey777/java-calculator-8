package calculator.util;

import java.util.Arrays;

public class NumberConverter {
    public static int[] convert(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(token -> !token.trim().isEmpty())
                .mapToInt(NumberConverter::parseNumber)
                .toArray();
    }

    private static int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());
            NumberValidator.validate(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력: " + token);
        }
    }
}
