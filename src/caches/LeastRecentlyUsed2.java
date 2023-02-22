package caches;

import java.util.LinkedHashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/lru-cache/
// Solution Link: https://leetcode.com/problems/lru-cache/solutions/45939/laziest-implementation-java-s-linkedhashmap-takes-care-of-everything/

// All Approaches: Time Complexity: O(1), Space Complexity: O(N)

// Approach #2: Extend the in-built LinkedHashMap Data Structure

public class LeastRecentlyUsed2 extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LeastRecentlyUsed2(int capacity) {

        super(capacity, 0.75f, true);

        this.capacity = capacity;
    }

    public int get(int key) { return super.getOrDefault(key, -1); }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {

        return size() > capacity;
    }
}