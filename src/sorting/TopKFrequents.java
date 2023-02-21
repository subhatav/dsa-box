package sorting;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/top-k-frequent-elements/
// Solution Link: https://www.youtube.com/watch?v=YPTqKIgVk-k

// Approach: Bucket Sort Technique; Time Complexity: O(N), Space Complexity: O(N)

public class TopKFrequents {

    public int[] compute(int[] nums, int k) {

        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new LinkedList[nums.length + 1];
        Map<Integer, Integer> freqs = new HashMap<>();

        int[] tops = new int[k];

        for (int num : nums) {

            int freq = freqs.getOrDefault(num, 0);

            freqs.put(num, freq + 1);
        }

        for (int num : freqs.keySet()) {

            int freq = freqs.get(num);

            if (buckets[freq] == null) {

                buckets[freq] = new LinkedList<>();
            }

            buckets[freq].add(num);
        }

        int index = k, freq = buckets.length;

        while (--freq > 0 && k > 0) {

            if (buckets[freq] != null) {

                for (int num : buckets[freq]) {

                    tops[index - k] = num;

                    if (--k == 0) break;
                }
            }
        }

        return tops;
    }
}