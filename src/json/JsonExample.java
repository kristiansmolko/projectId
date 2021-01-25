package json;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

public class JsonExample {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("name", "Milan");
        object.put("age", 32);
        object.put("active", true);
        JSONArray sports = new JSONArray();
        sports.add("hockey");
        sports.add("baseball");
        sports.add("cricket");
        object.put("sport", sports);
        System.out.println(object);
    }
}

