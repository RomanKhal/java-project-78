package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumberSchemaTest {
    NumberSchema numberSchema;

    @BeforeEach
    void beforeEach() {
        numberSchema = new NumberSchema();
    }

    @Test
    void testNull() {
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.required().isValid(null));
    }

    @Test
    void testPositive() {
        assertTrue(numberSchema.isValid(null));
        assertFalse(numberSchema.positive().isValid(-1));
    }

    @Test
    void testRange() {
        numberSchema.range(2, 4);
        assertFalse(numberSchema.isValid(1));
        assertFalse(numberSchema.isValid(5));
        assertTrue(numberSchema.isValid(2));
        assertTrue(numberSchema.isValid(4));
    }
}
