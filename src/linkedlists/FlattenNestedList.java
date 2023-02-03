package linkedlists;

// Problem Link: https://www.codingninjas.com/codestudio/problems/1112655
// Solution Link: https://takeuforward.org/data-structure/flattening-a-linked-list/

// Approach: Recursively MERGE from END; Time Complexity: O(N), Space Complexity: O(1)

public class FlattenNestedList {

    static class NestedNode {

        int value = 0;

        NestedNode next = null;
        NestedNode child = null;

        NestedNode(int value) { this.value = value; }
    }

    public NestedNode compute(NestedNode root) {

        if (root == null) return root;
        if (root.next == null) return root;

        // Go deep to LAST Parent Node
        root.next = compute(root.next);

        // Merge CURRENT & NEXT Nodes
        return merge(root, root.next);
    }

    private NestedNode merge(NestedNode list1, NestedNode list2) {

        NestedNode dummy = new NestedNode(0);
        NestedNode merged = dummy;

        while (list1 != null && list2 != null) {

            if (list1.value < list2.value) {

                dummy.child = list1;
                list1 = list1.child;

            } else {

                dummy.child = list2;
                list2 = list2.child;
            }

            dummy = dummy.child;
        }

        dummy.child = (list1 != null) ? list1 : list2;

        return merged.child;
    }
}