package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiters {
    private static final List<String> DEFAULT_DELIMITERS = Arrays.asList(",", ":");

    private final List<String> delimiters;

    private Delimiters(List<String> delimiters) {
        this.delimiters = new ArrayList<>(delimiters);
    }

    public static Delimiters createDefault() {
        return new Delimiters(DEFAULT_DELIMITERS);
    }

    public static Delimiters createWithCustom(String customDelimiter) {
        List<String> allDelimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        allDelimiters.add(customDelimiter);
        return new Delimiters(allDelimiters);
    }

    public String[] split(String input) {
        String pattern = createPattern();
        return input.split(pattern);
    }

    private String createPattern() {
        StringBuilder pattern = new StringBuilder("[");
        for (String delimiter : delimiters) {
            pattern.append(Pattern.quote(delimiter));
        }
        pattern.append("]");
        return pattern.toString();
    }
}

