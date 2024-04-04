package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public final class StringSchemaTest {
    private StringSchema schema;

    @BeforeEach
    void beforeEach() {
        Validator v = new Validator();
        schema = v.string();
    }

    @Test
    void testNull() {
        assertTrue(schema.isValid(""));
    }

    @Test
    void testNotNull() {
        schema.required();
        assertFalse(schema.isValid(""));
    }

    @Test
    void testMinLength() {
        String str = "adcd";
        schema.minLength(str.length() + 1);
        assertFalse(schema.isValid(str));
        schema.minLength(str.length() - 1);
        assertTrue(schema.isValid(str));

    }

    @Test
    void testContains() {
        schema.contains("abc");
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("abc"));
        schema.contains("def");
        assertFalse(schema.isValid("abc"));
        assertTrue(schema.isValid("defabc"));
    }

    @Test
    void testOverAll() {
        schema.required().minLength(4).contains("av");
        assertTrue(schema.isValid("aavv"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("av"));
        schema.required();
        assertTrue(schema.isValid(null));
        schema.required().contains("avvvv");
        assertFalse(schema.isValid("aavv"));
    }
}
