package DSA;
import DSA.HashMapCodeExtended.*;

import java.util.ArrayList;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMapDesign<Integer, String, String> map = new HashMapDesign<>();
        map.put(1, "India", "India,");
        map.put(2, "China", "Chiness,");
        map.put(3, "US", "American,");
        map.put(4, "Russia", "Russian,");
        map.put(5, "japan", "japaness,");
        map.put(6, "Koria", "Korian,");

        /*for (Object obj : map.entrySet()) {
            Map.Entry<String, String> entry = (Map.Entry) obj;
            System.out.print("Key: " + entry.getKey());
            System.out.println(", Value: " + entry.getValue());
        }*/

    /*    ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println("Key: " + key);
            System.out.println("Value1: " + map.getValue1(key));
            System.out.println("Value2: " + map.getValue2(key));
            System.out.println("===============================");
        }*/
    }
}
