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

// Approach: Traverse the Nodes LEVEL-wise and maintain a MAP of the Node VALUES w.r.t. the Line INDICES

public class ViewTopAndBottom {

    static class Pair {

        int line = 0;
        TreeNode node = null;

        Pair(int line, TreeNode node) {

            this.line = line;
            this.node = node;
        }
    }

    private Map<Integer, Integer> lines;
    private Queue<Pair> nodes;

    public List<Integer> compute(TreeNode root) {

        if (root == null) return new LinkedList<>();

        // SORT Map, according
        // to the Line INDICES
        lines = new TreeMap<>();
        nodes = new LinkedList<>();

        return watch(root);
    }

    private List<Integer> watch(TreeNode root) {

        // Set off the QUEUE with the ROOT
        nodes.add(new Pair(0, root));

        while (!nodes.isEmpty()) {

            Pair current = nodes.poll();

            int line = current.line;
            TreeNode node = current.node;

            TreeNode left = node.left, right = node.right;

            lines.putIfAbsent(line, node.value); // To view from TOP
            lines.put(line, node.value); // When viewing from BOTTOM

            if (left != null) nodes.offer(new Pair(line - 1, left));
            if (right != null) nodes.offer(new Pair(line + 1, right));
        }

        return new LinkedList<>(lines.values());
    }
}
