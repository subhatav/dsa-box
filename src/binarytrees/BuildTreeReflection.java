package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://practice.geeksforgeeks.org/problems/mirror-tree/1
// Solution Link: https://discuss.geeksforgeeks.org/comment/8b09ac7d06f57dcbcb742b5f26da3152

// Approch Link: SWAP the LEFT with RIGHT Sub-Trees in BOTTOM-UP Method
// Time Complexity: O(N); Space Complexity: O(N) in the Recursion Space

public class BuildTreeReflection {

    public void compute(TreeNode node) {

        node = mirror(node);
    }

    private TreeNode mirror(TreeNode root) {

        if (root == null) return null;

        TreeNode left = mirror(root.left);
        TreeNode right = mirror(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
