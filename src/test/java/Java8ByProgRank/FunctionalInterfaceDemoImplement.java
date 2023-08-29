package Java8ByProgRank;


import java.util.HashMap;
import java.util.Map;

public class FunctionalInterfaceDemoImplement
{

    public static void main(String[] args)
    {
        //FunctionalInterfaceDemo lamda =(int a,int b) -> System.out.println(a+b);

        //FunctionalInterfaceDemo lamda1 =(a, b) -> a+b;
        //FunctionalInterfaceDemo add = (a, b) -> a + b;
        //System.out.println( add.printNum(5,6));

        /*FunctionalInterfaceDemo<String, Integer> mapGenerator = () -> {
            Map<String, Integer> map = new HashMap<>();
            map.put("one", 1);
            map.put("two", 2);
            map.put("three", 3);
            return map;
        };*/
// Using lambda expression to implement the MapProvider functional interface
        // Using lambda expression to implement the MapProvider functional interface
        FunctionalInterfaceDemo<String, Integer> hashMap_new = HashMap::new;

        // Calling the createMap method using the lambda expression
        Map<String, Integer> hashMap = hashMap_new.generateMap();
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        // Printing the contents of the created HashMap
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
