package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        Delimiter delimiter = new Delimiter();
        if (hasCustomDelimiter(input)) {
            delimiter.addDelimiter(extractCustomDelimiter(input));
        }

        
    }

    private static boolean hasCustomDelimiter(String input) {
        if (input == null) {
            return false;
        }
        return input.matches("^//.\\n.*");
    }

    private static String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("^//(.)\n.*");
        Matcher matcher = pattern.matcher(input);

        matcher.find();
        return matcher.group(1);
    }
}
