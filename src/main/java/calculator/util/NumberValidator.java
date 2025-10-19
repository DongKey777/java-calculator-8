package calculator.util;

public class NumberValidator {
    public static void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능: " + number);
        }
    }
}
