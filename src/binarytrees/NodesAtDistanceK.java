package binarytrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
// Solution Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/solutions/143798/1ms-beat-100-simple-java-dfs-with-without-hashmap-including-explanation/

// Approach: Use Recursive Technique; Time Complexity: O(N), Space Complexity: O(N + N)

public class NodesAtDistanceK {

    private Map<TreeNode, Integer> map;
    private List<Integer> nodes;

    public List<Integer> compute(TreeNode root, TreeNode target, int k) {

        map = new HashMap<>();
        nodes = new LinkedList<>();

        search(root, target);
        enlist(root, k, map.get(root));

        return nodes;
    }

    private int search(TreeNode node, TreeNode target) {

        if (node == null) return -1;

        if (node == target) {

            map.put(node, 0);
            return 0;
        }

        int left = search(node.left, target);

        if (left >= 0) {

            map.put(node, left + 1);
            return left + 1;
        }

        int right = search(node.right, target);

        if (right >= 0) {

            map.put(node, right + 1);
            return right + 1;
        }

        return -1;
    }

    private void enlist(TreeNode node, int k, int length) {

        if (node == null) return;

        length = map.getOrDefault(node, length);

        if (length == k) nodes.add(node.value);

        enlist(node.left, k, length + 1);
        enlist(node.right, k, length + 1);
    }
}