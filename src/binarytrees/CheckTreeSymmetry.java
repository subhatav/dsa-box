package binarytrees;

import java.util.Stack;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/symmetric-tree/
// Solution Link: https://leetcode.com/problems/symmetric-tree/solutions/33054/recursive-and-non-recursive-solutions-in-java/

// Approach #1: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class CheckTreeSymmetry {

    public boolean compute1(TreeNode root) {

        if (root == null) return true;

        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) return true;

        if (left == null || right == null) return false;
        if (left.value != right.value) return false;

        return mirror(left.left, right.right)
            && mirror(left.right, right.left);
    }

    public boolean compute2(TreeNode root) {

        if (root == null) return true;

        Stack<TreeNode> nodes = new Stack<>();

        nodes.push(root.left);
        nodes.push(root.right);

        while (!nodes.isEmpty()) {

            TreeNode left = nodes.pop();
            TreeNode right = nodes.pop();

            if (left == null && right == null) continue;

            if (left == null || right == null) return false;
            if (left.value != right.value) return false;

            nodes.push(left.left);
            nodes.push(right.right);

            nodes.push(left.right);
            nodes.push(right.left);
        }

        return true;
    }
}