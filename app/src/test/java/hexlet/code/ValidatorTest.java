package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void string() {
        assertEquals(StringSchema.class, new Validator().string().getClass());
    }
}