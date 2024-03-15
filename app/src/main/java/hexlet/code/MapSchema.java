package hexlet.code;


import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    private int sizeOf;

    public MapSchema() {
        this.sizeOf = -1;
    }

    MapSchema sizeOf(int sizeOf) {
        this.sizeOf = sizeOf;
        return this;
    }
    @Override
    public boolean isValid(Map kvMap) {
        if (required && kvMap == null) {
            return false;
        }
        if (sizeOf != -1) {
            if (kvMap.size() != sizeOf){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MapSchema mapSchema = new MapSchema();
        mapSchema.required();
        mapSchema.sizeOf(1);
        var map = Map.of("key", "val");
        System.out.println(mapSchema.isValid(null));
    }
}
