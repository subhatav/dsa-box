package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem [Top] Link: https://www.codingninjas.com/codestudio/problems/799401
// Problem [Bottom] Link: https://www.codingninjas.com/codestudio/problems/893110

// Solution [Top] Link: https://takeuforward.org/data-structure/top-view-of-a-binary-tree/
// Solution [Bottom] Link: https://takeuforward.org/data-structure/bottom-view-of-a-binary-tree/

// Approach: Traverse the Nodes LEVEL-wise and maintain a MAP of the Node VALUES w.r.t. the Axis INDICES

public class ViewTopAndBottom {

    static class Pair {

        int axis = 0;
        TreeNode node = null;

        Pair(int axis, TreeNode node) {

            this.axis = axis;
            this.node = node;
        }
    }

    private Map<Integer, Integer> lines;
    private Queue<Pair> nodes;

    public List<Integer> compute(TreeNode root) {

        if (root == null) return new LinkedList<>();

        // SORT Map, according
        // to the Axis INDICES
        lines = new TreeMap<>();
        nodes = new LinkedList<>();

        return watch(root);
    }

    private List<Integer> watch(TreeNode root) {

        // Set off the QUEUE with the ROOT
        nodes.add(new Pair(0, root));

        while (!nodes.isEmpty()) {

            Pair current = nodes.poll();

            int axis = current.axis;
            TreeNode node = current.node;

            TreeNode left = node.left, right = node.right;

            lines.putIfAbsent(axis, node.value); // To view from TOP
            lines.put(axis, node.value); // When viewing from BOTTOM

            if (left != null) nodes.offer(new Pair(axis - 1, left));
            if (right != null) nodes.offer(new Pair(axis + 1, right));
        }

        return new LinkedList<>(lines.values());
    }
}
