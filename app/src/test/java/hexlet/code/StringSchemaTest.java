package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSchemaTest {
    StringSchema schema;

    @BeforeEach
    void beforeEach() {
        schema = new StringSchema();
    }

    @Test
    void testNull() {
        assertTrue(schema.isValid(""));
    }

    @Test
    void testNotNull() {
        assertFalse(schema.required().isValid(""));
    }

    @Test
    void testMinLength() {
        String str = "adcd";
        schema.minLength(str.length() - 1);
        assertFalse(schema.isValid(str));

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
}
