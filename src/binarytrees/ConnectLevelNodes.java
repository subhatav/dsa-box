package binarytrees;

// Problem Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
// Solution Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/solutions/1654181/c-python-java-simple-solution-w-images-explanation-bfs-dfs-o-1-optimized-bfs/

// Approach #1: Use Recursive Depth-First Technique
// Time Complexity: O(N); Space Complexity: O(logN)
// Maximum Height of a Perfect Binary Tree = log(N)

// Approach #2: Use Iterative, Space-Optimized Breadth-First Function
// Time Complexity: O(N); Space Complexity: O(1), with no Extra Space

public class ConnectLevelNodes {

    static class LinkedTree {

        int value = 0;

        LinkedTree left = null;
        LinkedTree right = null;

        LinkedTree next = null;

        LinkedTree(int value) { this.value = value; }

        LinkedTree(int value, LinkedTree left,
                              LinkedTree right,
                              LinkedTree next) {

            this.value = value;

            this.left = left;
            this.right = right;

            this.next = next;
        }
    }

    public LinkedTree compute1(LinkedTree root) {

        if (root == null) return null;

        LinkedTree left = root.left;
        LinkedTree right = root.right;

        LinkedTree next = root.next;

        if (left != null) {

            left.next = right;

            if (next != null) {

                right.next = next.left;
            }

            compute1(left);
            compute1(right);
        }

        return root;
    }

    public LinkedTree compute2(LinkedTree root) {

        LinkedTree head = root;

        while (root != null) {

            LinkedTree node = root;

            while (node != null) {

                LinkedTree left = node.left;
                LinkedTree right = node.right;

                LinkedTree next = node.next;

                if (left != null) {

                    left.next = right;

                    if (next != null) {

                        right.next = next.left;
                    }

                } else break;

                node = node.next;
            }

            root = root.left;
        }

        return head;
    }
}