package binarytrees;

import java.util.LinkedList;
import java.util.Stack;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem #1 Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
// Problem #2 Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
// Problem #3 Link: https://leetcode.com/problems/binary-tree-postorder-traversal/

// Solution #1 Link: https://leetcode.com/problems/binary-tree-preorder-traversal/solutions/45266/accepted-iterative-solution-in-java-using-stack/comments/44815
// Solution #2 Link: https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/31213/iterative-solution-in-java-simple-and-readable/comments/188986
// Solution #3 Link: https://leetcode.com/problems/binary-tree-postorder-traversal/solutions/45556/java-simple-and-clean/

// Approach #2 Link: https://leetcode.com/problems/binary-tree-inorder-traversal/solutions/31213/iterative-solution-in-java-simple-and-readable/comments/487633

// All Approaches: Stacking Technique; Time Complexity: O(N), Space Complexity: O(N)

public class IterativeTraversals {

    private LinkedList<Integer> nums;
    private Stack<TreeNode> nodes;

    public LinkedList<Integer> compute(TreeNode root) {

        nums = new LinkedList<>();

        pre(root); // Travels [Node-Left-Right]
        in(root); // Advances [Left-Node-Right]
        post(root); // Visits [Left-Right-Node]

        return nums;
    }

    private void pre(TreeNode root) {

        if (root == null) return;

        TreeNode node = root;

        nodes = new Stack<>();
        nodes.push(node);

        while (!nodes.empty()) {

            node = nodes.pop();
            nums.addLast(node.value);

            if (node.right != null) nodes.push(node.right);
            if (node.left != null) nodes.push(node.left);
        }
    }

    private void in(TreeNode root) {

        TreeNode node = root;

        nodes = new Stack<>();

        while (node != null || !nodes.empty()) {

            if (node != null) {

                nodes.push(node);
                node = node.left;

            } else {

                node = nodes.pop();
                nums.add(node.value);
                node = node.right;
            }
        }
    }

    private void post(TreeNode root) {

        if (root == null) return;

        TreeNode node = root;

        nodes = new Stack<>();
        nodes.push(node);

        while (!nodes.empty()) {

            node = nodes.pop();
            nums.addFirst(node.value);

            if (node.left != null) nodes.push(node.left);
            if (node.right != null) nodes.push(node.right);
        }
    }
}