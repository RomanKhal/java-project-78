package hexlet.code;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean positive;
    private final int[] range;

    public NumberSchema() {
        this.required = false;
        this.positive = false;
        this.range = new int[2];
    }

    NumberSchema required() {
        required = !required;
        return this;
    }

    NumberSchema positive() {
        positive = !positive;
        return this;
    }

    NumberSchema range(int min, int max) {
        range[0] = min;
        range[1] = max;
        return this;
    }


    public boolean isValid(Integer num) {
        if (required && num == null) {
            return false;
        }
        if (positive && num < 0) {
            return false;
        }
        return num == null || num >= range[0] && num <= range[1];
    }
}
