package binarytrees;

import java.util.LinkedList;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
// Solution Link: https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/106653/java-one-queue-solution-with-hashmap/comments/492554

// Approach: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class MaximumTreeWidth {

    static class Pair {

        int index = 0;
        TreeNode node = null;

        Pair(int index, TreeNode node) {

            this.index = index;
            this.node = node;
        }
    }

    private Queue<Pair> nodes;

    public int compute(TreeNode root) {

        int width = 0;

        if (root == null) return width;

        nodes = new LinkedList<>();

        nodes.offer(new Pair(0, root));

        while (!nodes.isEmpty()) {

            int capacity = nodes.size();

            int mark = 0, low = 0, high = 0;

            while ((mark += 1) <= capacity) {

                Pair current = nodes.poll();

                int index = current.index;
                TreeNode node = current.node;

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (mark == 1) low = index;
                if (mark == capacity) high = index;

                if (left != null) {

                    int child = (index * 2) + 1;

                    nodes.offer(new Pair(child, left));
                }

                if (right != null) {

                    int child = (index * 2) + 2;

                    nodes.offer(new Pair(child, right));
                }
            }

            width = Math.max(width, high - low + 1);
        }

        return width;
    }
}