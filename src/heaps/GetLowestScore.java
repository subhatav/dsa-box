package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// LeetCode Link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
// Solution Link: https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/solutions/3312059/java-priorityqueue-easy-to-understand/

// Approach: Use Index-based Sorting; Time Complexity: O(NlogN), Space Complexity: O(N)

public class GetLowestScore {

    static class Pair {

        int num, idx;

        Pair(int num, int idx) {

            this.num = num;
            this.idx = idx;
        }
    }

    private Comparator<Pair> comparer;
    private Queue<Pair> queue;

    public long compute(int[] nums) {

        long score = 0;

        int size = nums.length;

        comparer = (now, next) -> {

            if (now.num != next.num) {

                return (now.num - next.num);

            } else return (now.idx - next.idx);
        };

        queue = new PriorityQueue<>(size, comparer);

        for (int idx = 0; idx < size; idx += 1) {

            queue.add(new Pair(nums[idx], idx));
        }

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int idx = current.idx;

            if (nums[idx] != 0) {

                score += current.num;

                nums[idx] = 0;

                int left = idx - 1;
                int right = idx + 1;

                if (left >= 0) nums[left] = 0;
                if (right < size) nums[right] = 0;
            }
        }

        return score;
    }
}
