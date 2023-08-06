package HashMap;
import java.util.HashMap;
import java.util.Map;


public class NestedHashMapExample {
    public static void main(String[] args) {
    // Creating a nested hash map
    Map<String, Map<String, Integer>> nestedMap = new HashMap<>();

    // Adding values to the nested hash map
    nestedMap.computeIfAbsent("Category1", k -> new HashMap<>()).put("Item1", 10);
    nestedMap.computeIfAbsent("Category1", k -> new HashMap<>()).put("Item2", 20);
    nestedMap.computeIfAbsent("Category2", k -> new HashMap<>()).put("Item3", 15);

    // Getting and displaying values from the nested hash map
    int itemCount = nestedMap.getOrDefault("Category1", new HashMap<>()).getOrDefault("Item1", 0);
    System.out.println("Item count for Category1, Item1: " + itemCount);  // Output: Item count for Category1, Item1: 10

    // Iterating through the nested hash map
    for (Map.Entry<String, Map<String, Integer>> categoryEntry : nestedMap.entrySet()) {
        String category = categoryEntry.getKey();
        Map<String, Integer> items = categoryEntry.getValue();

        System.out.println("Category: " + category);
        for (Map.Entry<String, Integer> itemEntry : items.entrySet()) {
            String item = itemEntry.getKey();
            int quantity = itemEntry.getValue();
            System.out.println("  Item: " + item + ", Quantity: " + quantity);
        }
    }
}
}