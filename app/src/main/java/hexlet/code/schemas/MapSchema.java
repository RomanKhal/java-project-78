package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<?, ?>> {
    public MapSchema sizeof(int sizeOf) {
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
