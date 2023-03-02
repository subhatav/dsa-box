package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

// Solution Link: https://www.geeksforgeeks.org/morris-traversal-for-postorder/

// Approach: Morris Post-Order Traversal Process
// Time Complexity: O(N); Space Complexity: O(1)

public class MorrisPostOrderVisit {

    private LinkedList<Integer> nums;

    public List<Integer> compute(TreeNode root) {

        TreeNode last, node = root;

        nums = new LinkedList<>();

        while (node != null) {

            if (node.right == null) {

                nums.addFirst(node.value);
                node = node.left;

            } else {

                last = node.right;

                while (last.left != null &&
                       last.left != node) {

                    last = last.left;
                }

                if (last.left == null) {

                    last.left = node;
                    nums.addFirst(node.value);
                    node = node.right;

                } else {

                    last.left = null;
                    node = node.left;
                }
            }
        }

        return nums;
    }
}