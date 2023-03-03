package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Solution Link: https://takeuforward.org/data-structure/maximum-depth-of-a-binary-tree/

// Approach #1: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(H) in Recursion Space
// Approach #2: Use Breadth-First Technique; Time Complexity: O(N), Space Complexity: O(N) for Queue Size

public class MaximumTreeDepth {

    private Queue<TreeNode> nodes;

    public int compute(TreeNode root) {

        if (root == null) return 0;

        nodes = new LinkedList<>();

        TreeNode node;
        int depth = 0;

        nodes.offer(root);

        while (!nodes.isEmpty()) {

            int capacity = nodes.size();

            while (capacity > 0) {

                node = nodes.poll();

                if (node.left != null) nodes.offer(node.left);
                if (node.right != null) nodes.offer(node.right);
                
                capacity -= 1;
            }

            depth += 1;
        }

        return depth;
    }
}