package hexlet.code;

abstract class BaseSchema<T> {
    protected boolean required;

     BaseSchema<T> required() {
        required = !required;
        return this;
    }

    public boolean isValid(T t) {
        return true;
    }

}
