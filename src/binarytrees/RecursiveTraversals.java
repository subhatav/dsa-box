package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem #1 Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Problem #2 Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Problem #3 Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

// Solutions Link: https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/328601/all-dfs-traversals-preorder-postorder-inorder-in-java-in-5-lines/

// All Approaches: Depth-First Recursion Technique; Time Complexity: O(N), Space Complexity: O(N)

public class RecursiveTraversals {

    public List<Integer> compute(TreeNode root) {

        List<Integer> nums = new LinkedList<>();

        pre(root, nums); // Travels [Node-Left-Right]
        in(root, nums); // Advances [Left-Node-Right]
        post(root, nums); // Visits [Left-Right-Node]

        return nums;
    }

    private void pre(TreeNode root, List<Integer> nums) {

        if (root == null) return;

        nums.add(root.value);
        pre(root.left, nums);
        pre(root.right, nums);
    }

    private void in(TreeNode root, List<Integer> nums) {

        if (root == null) return;

        in(root.left, nums);
        nums.add(root.value);
        in(root.right, nums);
    }

    private void post(TreeNode root, List<Integer> nums) {

        if (root == null) return;

        post(root.left, nums);
        post(root.right, nums);
        nums.add(root.value);
    }
}