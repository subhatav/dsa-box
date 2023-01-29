package arrays;

// LeetCode Link: https://leetcode.com/problems/merge-sorted-array/

// Approach: Check, Store & Traverse; Time Complexity: O(N1 + N2), Space Complexity: O(1)

public class MergeSortedArrays {

    public void compute(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = (m + n) - 1;

        while (i >= 0 && j >= 0) {

            // Form the Merged Array descendingly in reverse
            if (nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }

        while (j >= 0) nums1[k--] = nums2[j--];
    }
}