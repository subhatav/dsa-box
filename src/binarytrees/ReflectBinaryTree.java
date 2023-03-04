package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/invert-binary-tree/
// Solution Link: https://discuss.geeksforgeeks.org/comment/8b09ac7d06f57dcbcb742b5f26da3152

// Approch Link: SWAP the LEFT with RIGHT Sub-Trees in BOTTOM-UP Method
// Time Complexity: O(N); Space Complexity: O(N) in the Recursion Space

public class ReflectBinaryTree {

    public TreeNode compute(TreeNode root) {

        if (root == null) return null;

        TreeNode left = compute(root.left);
        TreeNode right = compute(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
