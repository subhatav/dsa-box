package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

// Problem Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
// Solution Link: https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

// Average Time Complexity for ALL Operations: O(1)

public class CustomRandomSet {

    HashMap<Integer, Integer> hash;
    ArrayList<Integer> array;

    Random random;

    public CustomRandomSet() {

        hash = new HashMap<>();
        array = new ArrayList<>();

        random = new Random();
    }

    public boolean insert(int value) {

        // Skip if the Set already has the "value"
        if (hash.containsKey(value)) return false;

        hash.put(value, array.size());
        array.add(value);

        return true;
    }

    public boolean remove(int value) {

        // Skip if this Set do not have the "value"
        if (!hash.containsKey(value)) return false;

        int index = hash.get(value);
        int last = array.size() - 1;

        if (index < last) {

            // Swap with the Last Item
            int swap = array.get(last);

            hash.put(swap, index);
            array.set(index, swap);
        }

        hash.remove(value);
        array.remove(last);

        return true;
    }

    public int getRandom() {

        int index = random.nextInt(array.size());

        return array.get(index);
    }
}