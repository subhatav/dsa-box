package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

// Solution #1 Link: https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/33445/java-solution-using-dfs/
// Solution #2 Link: https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/33450/java-solution-with-a-queue-used/

// Approach #1: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class LevelOrderTraversal {

    private List<List<Integer>> order;
    private List<Integer> level;

    public List<List<Integer>> compute1(TreeNode root) {

        order = new LinkedList<>();

        travel(root, 0);

        return order;
    }

    private void travel(TreeNode node, int depth) {

        if (node == null) return;

        level = new LinkedList<>();

        // INSERT a new LIST for NEW Level of Depth
        if (depth == order.size()) order.add(level);

        // Dispense "depth" as the INDEX
        order.get(depth).add(node.value);

        travel(node.left, depth + 1);
        travel(node.right, depth + 1);
    }

    private Queue<TreeNode> nodes;

    public List<List<Integer>> compute2(TreeNode root) {

        order = new LinkedList<>();
        nodes = new LinkedList<>();

        if (root == null) return order;

        nodes.offer(root);

        while (!nodes.isEmpty()) {

            level = new LinkedList<>();

            int capacity = nodes.size();

            while ((capacity -= 1) >= 0) {

                TreeNode left = nodes.peek().left;
                TreeNode right = nodes.peek().right;

                if (left != null) nodes.offer(left);
                if (right != null) nodes.offer(right);

                level.add(nodes.poll().value);
            }

            order.add(level);
        }

        return order;
    }
}