package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class StringSchema extends BaseSchema<String> {
    private int minLength;
    private List<String> contains;

    public StringSchema() {
        this.required = false;
        this.minLength = -1;
        this.contains = new ArrayList<>();
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    public StringSchema contains(String str) {
        this.contains.add(str);
        return this;
    }

    @Override
    public boolean isValid(String string) {
        if (required && string.isEmpty()) {
            return false;
        }
        if (minLength >= 0) {
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
