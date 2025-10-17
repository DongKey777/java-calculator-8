package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        String inputStr = Calculator.input();
        System.out.println(inputStr);

        String[] numbers = Calculator.parse(inputStr);
        System.out.println(Arrays.toString(numbers));
    }
}
