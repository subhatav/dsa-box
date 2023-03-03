package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/
// Solution Link: https://leetcode.com/problems/average-of-levels-in-binary-tree/solutions/105107/java-bfs-solution/

// Approach: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class FindLevelAverages {

    private Queue<TreeNode> nodes;
    private List<Double> means;

    public List<Double> compute(TreeNode root) {

        nodes = new LinkedList<>();
        means = new LinkedList<>();

        if (root == null) return means;

        nodes.offer(root);

        while (!nodes.isEmpty()) {

            int capacity = nodes.size();

            double mean = 0, count = 0;

            while ((capacity -= 1) >= 0) {

                TreeNode node = nodes.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) nodes.offer(left);
                if (right != null) nodes.offer(right);

                mean += (node.value - mean) / (count += 1);
            }

            means.add(mean);
        }

        return means;
    }
}