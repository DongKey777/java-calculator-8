package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private final Delimiter delimiter;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+)\\\\n.*");
    private static final int DELIMITER_SUFFIX_LENGTH = 2;

    public Parser(Delimiter delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        if (!hasCustomDelimiter(input)) {
            return delimiter.split(input);
        }

        delimiter.addDelimiter(extractCustomDelimiter(input));
        String numbersToSplit = extractNumbers(input);
        return delimiter.split(numbersToSplit);
    }

    private boolean hasCustomDelimiter(String input) {
        return input.matches("^//.+\\\\n.*");
    }

    private String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        matcher.find();
        String delimiter = matcher.group(1);

        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 1글자여야 합니다.");
        }
        return delimiter;
    }

    private String extractNumbers(String input) {
        return input.substring(input.indexOf("\\n") + DELIMITER_SUFFIX_LENGTH);
    }
}
