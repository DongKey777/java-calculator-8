package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    public int calculate(String input) {
        String[] tokens = Parser.parse(input);
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
        List<Integer> numbers = new ArrayList<>();

        for (String token : tokens) {
            if (!token.trim().isEmpty()) {
                numbers.add(parseNumber(token));
            }
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }

    private int parseNumber(String token) {
        try {
            int number = Integer.parseInt(token.trim());

            if (number < 0) {
                throw new IllegalArgumentException("음수 입력 불가능" + number);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 입력 불가능" + token);
        }
    }
}
