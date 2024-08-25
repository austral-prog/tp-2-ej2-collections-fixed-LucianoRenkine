package com.collections;

import java.util.*;

public class Maps {

    public static Map<String, Integer> createInventory(List<String> items) {
        Map<String, Integer> dict = new HashMap<>();
        for (String item : items) {
            if (dict.containsKey(item)) {
                dict.put(item, dict.get(item) + 1);
            }
            else {
                dict.put(item, 1);
            }
        }
        return dict;
    }

    public Map<String, Integer> addItems(Map<String, Integer> inventory, List<String> items) {
        Map<String, Integer> addDict = new HashMap<>(createInventory(items));
        List<String> listOfItems = new ArrayList<>(inventory.keySet());
        for (int i = 0; i < inventory.size(); i++) {
            String item = listOfItems.get(i);
            if (addDict.containsKey(item)) {
                int amount = addDict.get(item);
                addDict.put(item, amount + inventory.get(item));
            }
            else {
                addDict.put(item, inventory.get(item));
            }
        }
        return addDict;
    }

    public static Map<String, Integer> decrementItems(Map<String, Integer> inventory, List<String> items) {
        Map<String, Integer> dictOfItems = new HashMap<>(createInventory(items));
        for (Map.Entry<String, Integer> entry : dictOfItems.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();

            if (inventory.containsKey(item)) {
                int amount = inventory.get(item);
                if (amount >= quantity) {
                    inventory.put(item, amount - quantity);
                }
                else {
                    inventory.put(item, 0);
                }
            }
            else {
                inventory.put(item, 0);
            }
        }
        return inventory;
    }

    public Map<String, Integer> removeItem(Map<String, Integer> inventory, String item) {
        if (inventory.containsKey(item)) {
            inventory.remove(item);
        }
        return inventory;
    }

    public List<Map.Entry<String, Integer>> listInventory(Map<String, Integer> inventory) {
        List<Map.Entry<String, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue() > 0) {
                result.add(entry);
            }
        }
        return result;
    }
}