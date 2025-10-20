package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("^//(.+)\\\\n.*");
    private static final int DELIMITER_SUFFIX_LENGTH = 2;

    public String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }
        Delimiters delimiters = determineDelimiters(input);
        String numbersPart = extractNumbers(input);

        return delimiters.split(numbersPart);
    }

    private Delimiters determineDelimiters(String input) {
        if (hasCustomDelimiter(input)) {
            String customDelimiter = extractCustomDelimiter(input);
            return Delimiters.createWithCustom(customDelimiter);
        }

        return Delimiters.createDefault();
    }

    private boolean hasCustomDelimiter(String input) {
        return input.matches("^//.+\\\\n.*");
    }

    private String extractCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);

        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }

        String delimiter = matcher.group(1);

        if (delimiter.length() != 1) {
            throw new IllegalArgumentException("커스텀 구분자는 1글자여야 합니다.");
        }

        return delimiter;
    }

    private String extractNumbers(String input) {
        if (!hasCustomDelimiter(input)) {
            return input;
        }
        return input.substring(input.indexOf("\\n") + DELIMITER_SUFFIX_LENGTH);
    }
}
