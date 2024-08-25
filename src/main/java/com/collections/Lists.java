package com.collections;

import java.util.ArrayList;
import java.util.List;

public class Lists {
    public static int indexOf(String color, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(color)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfByIndex(String color, List<String> list, int index) {
        for (int i = index; i < list.size(); i++) {
            if (list.get(i).equals(color)) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfEmpty(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("")) {
                return i;
            }
        }
        return -1;
    }

    public static int put(String color, List<String> list) {
        int index = indexOfEmpty(list);
        if (index == -1) {
         return -1;
        }
        list.set(index, color);
        return index;
    }


    public static int remove(String color, List<String> list) {
        List<String> removals = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(color)) {
                list.remove(i);
                removals.add("a");
            }
        }
        return removals.size();
    }
}
