package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int minLength) {
        criterias.put("minLength", val -> val.length() >= minLength);
        return this;
    }

    public StringSchema contains(String str) {
        criterias.put("contains", val -> val.contains(str));
        return this;
    }
    @Override
    public StringSchema required() {
        super.required();
        return this;
    }
}
