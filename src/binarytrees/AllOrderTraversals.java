package binarytrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import binarytrees.CustomBinaryTree.TreeNode;

// Problem Link: https://www.codingninjas.com/codestudio/problems/981269

// Solution Link: https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/

// Approach: Do COUNT times EACH Node is VISITED
// Time Complexity: O(N); Space Complexity: O(N)

public class AllOrderTraversals {

    static class Pair {

        int count = 0;

        TreeNode node = null;

        public Pair(int count, TreeNode node) {

            this.count = count;

            this.node = node;
        }
    }

    private List<Integer> ins, pres, posts;

    private List<List<Integer>> orders;

    public List<List<Integer>> compute(TreeNode root) {

        Stack<Pair> nodes = new Stack<>();

        ins = new LinkedList<>();
        pres = new LinkedList<>();
        posts = new LinkedList<>();

        orders = new LinkedList<>();

        if (root == null) return orders;

        nodes.push(new Pair(1, root));

        while (!nodes.isEmpty()) {

            Pair visited = nodes.pop();

            if (visited.count == 1) {

                pres.add(visited.node.value);

                visited.count += 1;
                nodes.push(visited);

                if (visited.node.left != null) {

                    nodes.push(new Pair(1, visited.node.left));
                }

            } else if (visited.count == 2) {

                ins.add(visited.node.value);

                visited.count += 1;
                nodes.push(visited);

                if (visited.node.right != null) {

                    nodes.push(new Pair(1, visited.node.right));
                }

            } else posts.add(visited.node.value);
        }

        orders.add(ins);
        orders.add(pres);
        orders.add(posts);

        return orders;
    }
}