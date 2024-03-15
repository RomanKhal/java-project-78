package hexlet.code;

abstract class BaseSchema<T> {
    protected boolean required;

    public boolean isValid(T t) {
        return true;
    }

}
