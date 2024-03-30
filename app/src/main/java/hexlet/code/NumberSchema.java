package hexlet.code;

public class NumberSchema extends BaseSchema<Number> {

    public NumberSchema positive() {
        getCriteria().put("positive", val -> val.intValue() > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        getCriteria().put("range", val -> val.doubleValue() >= min && val.intValue() <= max);
        return this;
    }

    @Override
    NumberSchema required() {
        super.required();
        return this;
    }
}
