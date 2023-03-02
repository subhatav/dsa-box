package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/balanced-binary-tree/
// Solution Link: https://leetcode.com/problems/balanced-binary-tree/solutions/35943/java-o-n-solution-based-on-maximum-depth-of-binary-tree/comments/127619

// Approach: Evaluate the Difference in Heights from both Sub-Trees
// Time Complexity: O(N); Space Complexity: O(H) in Auxiliary Space

public class VerifyTreeBalance {

    private boolean result = true;

    public boolean compute(TreeNode root) {

        height(root);

        return result;
    }

    private int height(TreeNode root) {

        if (!result) return 0;
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // ASSESS the Current Height DIFFERENCE
        int difference = Math.abs(left - right);

        // CONSTRAIN the Difference GAUGED
        if (difference > 1) result = false;

        // Return HEIGHT of CURRENT Tree
        return Math.max(left, right) + 1;
    }
}