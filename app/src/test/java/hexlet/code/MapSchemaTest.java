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

    @Test
    void testShape() {
        Map<String, Integer> td1 = Map.of("key1", -5, "key2", 7);
        Map<String, String> td2 = Map.of("key1", "val1", "key2", "val2");
        Validator validator = new Validator();
        Map<String, BaseSchema<Number>> numSchemas = new HashMap<>();
        numSchemas.put("key1", validator.number().range(-6, 6));
        numSchemas.put("key2", validator.number().positive().range(6, 9));

        mapSchema.shape(numSchemas);

        assertTrue(mapSchema.isValid(td1));

        Map<String, BaseSchema<String>> strSchemas = new HashMap<>();
        strSchemas.put("key1", validator.string().minLength(3));
        strSchemas.put("key2", validator.string().contains("val"));

        mapSchema.shape(strSchemas);

        assertTrue(mapSchema.isValid(td2));
    }
}
