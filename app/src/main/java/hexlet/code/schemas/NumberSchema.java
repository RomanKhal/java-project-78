package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Number> {

    public NumberSchema positive() {
        criterias.put("positive", val -> val.intValue() > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        criterias.put("range", val -> val.doubleValue() >= min && val.intValue() <= max);
        return this;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }
}
