package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Delimiter {
    private final List<String> delimiters;

    public Delimiter() {
        this.delimiters = new ArrayList<>();

        this.delimiters.add(",");
        this.delimiters.add(":");
    }

    public void addDelimiter(String delimiter) {
        delimiters.add(delimiter);
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
