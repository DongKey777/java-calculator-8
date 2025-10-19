package calculator;

import java.util.ArrayList;
import java.util.List;

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
}
