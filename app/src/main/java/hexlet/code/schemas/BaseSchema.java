package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    private boolean required;
    protected final Map<String, Predicate<T>> criterias;

    public BaseSchema() {
        this.criterias = new HashMap<>();
        this.required = false;
    }

    /**
     * Функция добавляет в схему ограничение, которое не позволяет использовать null в качестве значения
     *    отменяет ограничение при повторном вызове.
     * @see BaseSchema:required()
     * @return BaseSchema<T>
     */
    public BaseSchema<T> required() {
        required = !required;
        return this;
    }
    /**
     * Функция для валидации значений в соответствии со схемой.
     * @see BaseSchema:isValid()
     * @param val - значение для валидации
     * @return boolean
     */
    public boolean isValid(T val) {
        if (required) {
            if (val == null || val.equals("")) {
                return false;
            }
        }
        for (Map.Entry<String, Predicate<T>> criteria : criterias.entrySet()) {
            if (val != null && !criteria.getValue().test(val)) {
                return false;
            }
        }
        return true;
    }
//    /**
//     * Функция предоставляет доступ к @see BaseSchema:@param required.
//     * @see BaseSchema:getCriteria()
//     * @return Map<String, Predicate<T>>
//     */
//    Map<String, Predicate<T>> getCriteria() {
//        return this.criterias;
//    }
}
