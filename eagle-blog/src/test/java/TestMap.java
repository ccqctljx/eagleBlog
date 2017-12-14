import java.util.HashMap;
import java.util.Map;

/**
 * @Author 陈辰强
 * @Date 2017/8/8 23:16
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("key", null);

        System.out.println(map.get("key") == null);
        System.out.println(String.valueOf(map.get("key")));

        for (String key : map.keySet()) {
            System.out.println(map.get(key) == null);
        }

    }

}
