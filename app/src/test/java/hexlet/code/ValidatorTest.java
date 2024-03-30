package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidatorTest {
    private Validator validator;

    @BeforeEach
    void beforeEach() {
        validator = new Validator();
    }

    @Test
    void testString() {
        assertEquals(StringSchema.class, validator.string().getClass());
        assertEquals(StringSchema.class, validator.string().required().getClass());
        assertEquals(StringSchema.class, validator.string().minLength(2).getClass());
        assertEquals(StringSchema.class, validator.string().contains("asd").getClass());
    }

    @Test
    void testNumber() {
        assertEquals(NumberSchema.class, validator.number().getClass());
        assertEquals(NumberSchema.class, validator.number().required().getClass());
        assertEquals(NumberSchema.class, validator.number().positive().getClass());
        assertEquals(NumberSchema.class, validator.number().range(2, 4).getClass());
    }

    @Test
    void testMap() {
        assertEquals(MapSchema.class, validator.map().getClass());
        assertEquals(MapSchema.class, validator.map().required().getClass());
        assertEquals(MapSchema.class, validator.map().shape(new HashMap<>()).getClass());
        assertEquals(MapSchema.class, validator.map().sizeOf(1).getClass());
    }
}
