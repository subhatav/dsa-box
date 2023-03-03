package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

// Solution Link: https://takeuforward.org/data-structure/morris-preorder-traversal-of-a-binary-tree/

// Approach: Morris Pre-Order Traversal Process
// Time Complexity: O(N); Space Complexity: O(1)

public class MorrisPreOrderVisit {

    private LinkedList<Integer> nums;

    public List<Integer> compute(TreeNode root) {

        TreeNode last, node = root;

        nums = new LinkedList<>();

        while (node != null) {

            if (node.left == null) {

                nums.addLast(node.value);
                node = node.right;

            } else {

                last = node.left;

                while (last.right != null &&
                       last.right != node) {

                    last = last.right;
                }

                if (last.right == null) {

                    last.right = node;
                    nums.addLast(node.value);
                    node = node.left;

                } else {

                    last.right = null;
                    node = node.right;
                }
            }
        }

        return nums;
    }
}