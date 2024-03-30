package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private boolean required;
    private final Map<String, Predicate<T>> criterias;

    BaseSchema() {
        this.criterias = new HashMap<>();
        this.required = false;
    }

    BaseSchema<T> required() {
        required = !required;
        return this;
    }

    public boolean isValid(T val) {
        if (required) {
            if (val == null || val.equals("")) {
                return false;
            }
        }
        for (Map.Entry<String, Predicate<T>> criteria : criterias.entrySet()) {
            if (!criteria.getValue().test(val)) {
                return false;
            }
        }
        return true;
    }

    Map<String, Predicate<T>> getCriteria() {
        return this.criterias;
    }
}
