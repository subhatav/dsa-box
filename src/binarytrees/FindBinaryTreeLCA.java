package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
// Solution Link: https://takeuforward.org/data-structure/lowest-common-ancestor-for-two-given-nodes/

// Approach: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)

public class FindBinaryTreeLCA {

    public TreeNode compute(TreeNode root, TreeNode p,
                                           TreeNode q) {

        if (root == null) return root; // ABSENT

        // Node "ROOT" == LOWEST "Common" Parent
        if (root == p || root == q) return root;

        // Go through BOTH the SIDES for the LCA
        TreeNode left = compute(root.left, p, q);
        TreeNode right = compute(root.right, p, q);

        // LCA is FOUND in EITHER Sides
        if (left == null) return right;
        if (right == null) return left;

        return root; // LCA is the ROOT
    }
}