package binarytrees;

import java.util.Stack;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Solution Link: https://takeuforward.org/data-structure/flatten-binary-tree-to-linked-list/

// Approach #1: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #3: Morris Traversal Method; Time Complexity: O(N), Space Complexity: O(1)

public class FlattenBinaryTree {

    public void compute1(TreeNode root) {

        if (root == null) return;

        flatten(root, null);
    }

    private TreeNode flatten(TreeNode root, TreeNode last) {

        if (root == null) return last;

        last = flatten(root.right, last);
        last = flatten(root.left, last);

        root.right = last;
        root.left = null;

        last = root;

        return last;
    }

    private Stack<TreeNode> nodes;

    public void compute2(TreeNode root) {

        if (root == null) return;

        TreeNode node = root;

        nodes = new Stack<>();
        nodes.push(node);

        while (!nodes.isEmpty()) {

            node = nodes.pop();

            if (node.right != null) nodes.push(node.right);
            if (node.left != null) nodes.push(node.left);

            if (!nodes.isEmpty()) node.right = nodes.peek();

            node.left = null;
        }
    }

    public void compute3(TreeNode root) {

        TreeNode last, node = root;

        while (node != null) {

            if (node.left != null) {

                last = node.left;

                while (last.right != null) {

                    last = last.right;
                }

                last.right = node.right;
                node.right = node.left;

                node.left = null;
            }

            node = node.right;
        }
    }
}