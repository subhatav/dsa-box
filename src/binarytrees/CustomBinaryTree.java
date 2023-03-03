package binarytrees;

public class CustomBinaryTree {

    static class TreeNode {

        int value = 0;

        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int value) { this.value = value; }

        TreeNode(int value, TreeNode left,
                            TreeNode right) {

            this.value = value;

            this.left = left;
            this.right = right;
        }
    }
}
