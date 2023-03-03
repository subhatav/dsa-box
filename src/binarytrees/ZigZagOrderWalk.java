package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Solution #1 Link: https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/114449/a-general-approach-to-level-order-traversal-questions-in-java/
// Solution #2 Link: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/solutions/33815/my-accepted-java-solution/comments/32401

// Approach #1: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)
// Approach #2: Use Iterative Technique; Time Complexity: O(N), Space Complexity: O(N)

public class ZigZagOrderWalk {

    private List<List<Integer>> order;
    private List<Integer> level;

    public List<List<Integer>> compute1(TreeNode root) {

        order = new LinkedList<>();

        traverse(root, 0);

        return order;
    }

    private void traverse(TreeNode node, int depth) {

        if (node == null) return;

        level = new LinkedList<>();

        // INSERT a new LIST for NEW Level of Depth
        if (depth == order.size()) order.add(level);

        // Employ "depth" for the DIRECTION and as the INDEX
        if (depth % 2 == 0) order.get(depth).add(node.value);
        else order.get(depth).add(0, node.value);

        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }

    private Queue<TreeNode> nodes;

    public List<List<Integer>> compute2(TreeNode root) {

        boolean direction = true;

        order = new LinkedList<>();
        nodes = new LinkedList<>();

        if (root == null) return order;

        nodes.offer(root);

        while (!nodes.isEmpty()) {

            level = new LinkedList<>();

            int depth = nodes.size();

            while ((depth -= 1) >= 0) {

                TreeNode node = nodes.poll();

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) nodes.offer(left);
                if (right != null) nodes.offer(right);

                if (direction) level.add(node.value);
                else level.add(0, node.value);
            }

            direction = !direction;

            order.add(level);
        }

        return order;
    }
}