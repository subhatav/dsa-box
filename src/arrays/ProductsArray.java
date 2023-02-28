package arrays;

// Problem Link: https://leetcode.com/problems/product-of-array-except-self/

// Approach: Left & Right Product Arrays; Time Complexity: O(N)

public class ProductsArray {

    public int[] compute(int[] nums) {

        int size = nums.length;

        int[] left = new int[size];
        int[] right = new int[size];

        left[0] = right[size - 1] = 1;

        for (int index = 1; index < size; index++) {

            int offset = size - index;

            left[index] = left[index - 1] * nums[index - 1];
            right[offset - 1] = right[offset] * nums[offset];
        }

        for (int index = 0; index < size; index++) {

            nums[index] = left[index] * right[index];
        }

        return nums;
    }
}