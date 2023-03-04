package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://www.codingninjas.com/codestudio/problems/3843990
// Solution Link: https://takeuforward.org/data-structure/print-root-to-node-path-in-a-binary-tree/

// Approach: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N)

public class GetTargetNodePath {

    private List<Integer> path;

    public List<Integer> compute(TreeNode root, int x) {

        path = new LinkedList<>();

        travel(root, x);

        return path;
    }

    private boolean travel(TreeNode node, int x) {

        if (node == null) return false;

        path.add(node.value);

        if (node.value == x) return true;

        if (travel(node.left, x)) return true;
        if (travel(node.right, x)) return true;

        path.remove(path.size() - 1);

        return false;
    }
}