package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Calculator {
    private static final String DEFAULT_DELIMITERS = "[:,]";

    public static String input() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return readLine();
    }

    public static String[] parse(String inputStr) {
        String[] numbers = inputStr.split(DEFAULT_DELIMITERS);
        return numbers;
    }


}
