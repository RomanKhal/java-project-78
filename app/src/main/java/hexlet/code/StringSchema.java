package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema {
    private boolean required;
    private int minLength;
    private List<String> contains;

    public StringSchema() {
        this.required = false;
        this.minLength = -1;
        this.contains = new ArrayList<>();
    }

    public void required() {
        this.required = true;
    }

    public void minLength(int minLength) {
        this.minLength = minLength;
    }

    public void contains(String str) {
        this.contains.add(str);
    }

    public boolean isValid(String string) {
        if (required && string.isEmpty()) {
            return false;
        }
        if  (minLength >= 0) {
            if (string.length() > minLength) {
                return false;
            }
        }
        for (String candidate : contains) {
            if (!string.contains(candidate)) {
                return false;
            }
        }
        return true;
    }
}
