package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/diameter-of-binary-tree/
// Solution Link: https://takeuforward.org/data-structure/calculate-the-diameter-of-a-binary-tree/

// Approach: Calculate the Maximum Sum of Heights of both Sub-Trees
// Time Complexity: O(N); Space Complexity: O(H) in Recursion Space

public class FindTreeDiameter {

    private int answer = 0;

    public int compute(TreeNode root) {

        height(root);

        return answer;
    }

    private int height(TreeNode root) {

        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // Garner CURRENT Diameter
        int current = left + right;

        // MAXIMIZE the Diameter deposited
        answer = Math.max(answer, current);

        // Return HEIGHT of CURRENT Tree
        return Math.max(left, right) + 1;
    }
}