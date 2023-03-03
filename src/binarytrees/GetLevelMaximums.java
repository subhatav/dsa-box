package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
// Solution Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/solutions/98976/java-bfs/

// Approach: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class GetLevelMaximums {

    private Queue<TreeNode> nodes;
    private List<Integer> maxes;

    public List<Integer> compute(TreeNode root) {

        nodes = new LinkedList<>();
        maxes = new LinkedList<>();

        if (root == null) return maxes;

        nodes.offer(root);

        while (!nodes.isEmpty()) {

            int max = Integer.MIN_VALUE;

            int capacity = nodes.size();

            while ((capacity -= 1) >= 0) {

                TreeNode node = nodes.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) nodes.offer(left);
                if (right != null) nodes.offer(right);

                max = Math.max(max, node.value);
            }

            maxes.add(max);
        }

        return maxes;
    }
}