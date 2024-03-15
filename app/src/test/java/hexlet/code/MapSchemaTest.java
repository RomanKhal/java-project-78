package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapSchemaTest {
    private MapSchema mapSchema;

    @BeforeEach
    void beforeEach() {
        mapSchema = new MapSchema();
    }

    @Test
    void testNull() {
        assertTrue(mapSchema.isValid(null));
        assertFalse(mapSchema.required().isValid(null));
    }
    @Test
    void testSize() {
        assertFalse(mapSchema.sizeOf(1).isValid(new HashMap<>()));
        assertTrue(mapSchema.sizeOf(1).isValid(Map.of("key", "value")));
    }
}