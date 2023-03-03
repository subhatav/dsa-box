package binarytrees;

import java.util.LinkedList;
import java.util.List;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem [Left] Link: https://www.codingninjas.com/codestudio/problems/920519
// Problem [Right] Link: https://www.codingninjas.com/codestudio/problems/764605

// Solution Link: https://takeuforward.org/data-structure/right-left-view-of-binary-tree/

// Approach Link: https://leetcode.com/problems/binary-tree-right-side-view/solutions/56012/my-simple-accepted-solution-java/comments/57608

// Time Complexity: O(N); Space Complexity: O(H) in Recursion Space

public class GetTreeSideViews {

    private List<Integer> view;

    public List<Integer> compute(TreeNode root) {

        view = new LinkedList<>();

        left(root, 0); // Observes from LEFT-Side
        right(root, 0); // Espies from RIGHT-Side

        return view;
    }

    private void left(TreeNode node, int depth) {

        if (node == null) return;

        // Make SURE that the FIRST Element of CURRENT
        // Level will be ADDED to the LIST of Elements
        if (depth == view.size()) view.add(node.value);

        // PREFERENCE Order is set
        // according to SIDE taken
        left(node.left, depth + 1);
        left(node.right, depth + 1);
    }

    private void right(TreeNode node, int depth) {

        if (node == null) return;

        // Make SURE that the FIRST Element of CURRENT
        // Level will be ADDED to the LIST of Elements
        if (depth == view.size()) view.add(node.value);

        // PREFERENCE Order is laid
        // according to SIDE chosen
        right(node.right, depth + 1);
        right(node.left, depth + 1);
    }
}