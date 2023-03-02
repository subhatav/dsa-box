package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

// Solution Link: https://takeuforward.org/data-structure/morris-inorder-traversal-of-a-binary-tree/

// Approach: Morris In-Order Traversal Technique
// Time Complexity: O(N); Space Complexity: O(1)

public class MorrisInOrderVisit {

    private LinkedList<Integer> nums;

    public List<Integer> compute(TreeNode root) {

        TreeNode node = root, last;

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
                    node = node.left;

                } else {

                    last.right = null;
                    nums.add(node.value);
                    node = node.right;
                }
            }
        }

        return nums;
    }
}