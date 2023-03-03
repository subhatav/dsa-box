package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://www.codingninjas.com/codestudio/problems/790725
// Solution Link: https://www.javatpoint.com/boundary-traversal-of-binary-tree

// Approach: Append LEFTIES, LEAVES and RIGHTIES
// Time Complexity: O(N); Space Complexity: O(N)

public class BoundaryTraversal {

    private List<Integer> nums;

    public List<Integer> compute(TreeNode root) {

        nums = new LinkedList<>();

        if (root == null) return nums;

        nums.add(root.value);

        lefties(root.left);

        leaves(root.left);
        leaves(root.right);

        righties(root.right);

        return nums;
    }

    protected void lefties(TreeNode node) {

        if (node == null) return;
        if (leaf(node) == true) return;

        nums.add(node.value);

        if (node.left != null) {

            lefties(node.left);

        } else lefties(node.right);
    }

    protected void leaves(TreeNode node) {

        if (node == null) return;

        if (leaf(node) == false) {

            leaves(node.left);
            leaves(node.right);
        }

        nums.add(node.value);
    }

    protected void righties(TreeNode node) {

        if (node == null) return;
        if (leaf(node) == true) return;

        if (node.right != null) {

            righties(node.right);

        } else righties(node.left);

        nums.add(node.value);
    }

    private boolean leaf(TreeNode node) {

        return (node.left == null)
            && (node.right == null);
    }
}