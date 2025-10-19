package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Delimiter delimiter;

    public Parser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String numbersToSplit = input;

        if (hasCustomDelimiter(input)) {
            delimiter.addDelimiter(extractCustomDelimiter(input));
            numbersToSplit = extractNumbers(input);
        }

        return delimiter.split(numbersToSplit);
    }

    private boolean hasCustomDelimiter(String input) {
        if (input == null) {
            return false;
        }
        return input.matches("^//.\\\\n.*");
    }

    private String extractCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("^//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);

        matcher.find();
        return matcher.group(1);
    }

    private String extractNumbers(String input) {
        return input.substring(input.indexOf("\\n") + 2);
    }
}
