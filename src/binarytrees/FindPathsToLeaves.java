package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/binary-tree-paths/
// Solution Link: https://leetcode.com/problems/binary-tree-paths/solutions/68258/accepted-java-simple-solution-in-8-lines/

public class FindPathsToLeaves {

    private List<String> paths;

    public List<String> compute(TreeNode root) {

        paths = new LinkedList<>();

        if (root == null) return paths;

        traverse(root, "");

        return paths;
    }

    private void traverse(TreeNode node, String path) {

        TreeNode left = node.left;
        TreeNode right = node.right;

        path += node.value;

        if (left == null && right == null) paths.add(path);

        if (left != null) traverse(left, path + "->");
        if (right != null) traverse(right, path + "->");
    }
}