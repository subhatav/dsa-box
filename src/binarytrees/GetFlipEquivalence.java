package binarytrees;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://leetcode.com/problems/flip-equivalent-binary-trees/
// Solution Link: https://leetcode.com/problems/flip-equivalent-binary-trees/solutions/200514/java-python-3-dfs-3-liners-and-bfs-with-explanation-time-space-o-n/

// Approach: Check BOTH Sub-Trees [LEFT & RIGHT] for both UNFLIPPED & FLIPPED Cases
// Time Complexity: O(N^2) for 4 Sub-Problems; but O(N) for UNIQUE Numbers in Nodes
// Space Complexity: O(H) for PERFECT Binary Tree; else O(N) for SKEWED Binary Tree

public class GetFlipEquivalence {

    public boolean compute(TreeNode root1, TreeNode root2) {

        if (root1 == null) return (root2 == null);
        if (root2 == null) return (root1 == null);

        if (root1.value != root2.value) return false;

        boolean unflipped = (compute(root1.left, root2.left) &&
                             compute(root1.right, root2.right));

        boolean flipped = (compute(root1.left, root2.right) &&
                           compute(root1.right, root2.left));

        return (unflipped || flipped);
    }
}
