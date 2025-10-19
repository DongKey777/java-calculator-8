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
        int number = Integer.parseInt(token.trim());
        return number;
    }
}
