package HashMap;

import java.util.HashMap;
import java.util.Map;

class NestedHashMap {
    private Map<String, Map<String, Integer>> outerMap;

    public NestedHashMap() {
        outerMap = new HashMap<>();
    }

    public void addItem(String category, String item, int quantity) {
        outerMap.computeIfAbsent(category, k -> new HashMap<>()).put(item, quantity);
    }

    public int getItemQuantity(String category, String item) {
        Map<String, Integer> innerMap = outerMap.get(category);
        if (innerMap != null) {
            return innerMap.getOrDefault(item, 0);
        }
        return 0;
    }

    public void displayItems() {
        for (Map.Entry<String, Map<String, Integer>> categoryEntry : outerMap.entrySet()) {
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

public class NestedHashMapExample1 {
    public static void main(String[] args) {
        NestedHashMap nestedHashMap = new NestedHashMap();

        // Adding items to the nested hash map
        nestedHashMap.addItem("Category1", "Item1", 10);
        nestedHashMap.addItem("Category1", "Item2", 20);
        nestedHashMap.addItem("Category2", "Item3", 15);

        // Displaying item quantities
        int itemQuantity = nestedHashMap.getItemQuantity("Category1", "Item1");
        System.out.println("Item quantity for Category1, Item1: " + itemQuantity);  // Output: Item quantity for Category1, Item1: 10

        // Displaying all items
        System.out.println("All items in the nested hash map:");
        nestedHashMap.displayItems();
    }
}