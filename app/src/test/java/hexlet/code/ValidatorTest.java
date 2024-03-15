package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {

    @Test
    void string() {
        assertEquals(StringSchema.class, new Validator().string().getClass());
    }

    @Test
    void number() {
        assertEquals(NumberSchema.class, new Validator().number().getClass());
    }
}