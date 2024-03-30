package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema sizeOf(int sizeOf) {
        getCriteria().put("sizeOf", val -> val.size() == sizeOf);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        getCriteria().put("shape", val -> schemas.entrySet().stream().allMatch(e -> {
            var v = e.getKey();
            var schema = e.getValue();
            return schema.isValid((T) val.get(v));
        }));
        return this;
    }
}
