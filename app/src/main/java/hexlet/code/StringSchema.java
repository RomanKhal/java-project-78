package hexlet.code;

public class StringSchema extends BaseSchema<String> {

    public StringSchema minLength(int minLength) {
        getCriteria().put("minLength", val -> val.length() >= minLength);
        return this;
    }

    public StringSchema contains(String str) {
        getCriteria().put("contains", val -> val.contains(str));
        return this;
    }
    @Override
    StringSchema required() {
        super.required();
        return this;
    }
}
