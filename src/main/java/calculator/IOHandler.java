package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class IOHandler {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";

    public static String readInput() {
        System.out.println(INPUT_MESSAGE);
        return readLine();
    }

    public static void printResult(int result) {
        System.out.println(RESULT_PREFIX + result);
    }
}
