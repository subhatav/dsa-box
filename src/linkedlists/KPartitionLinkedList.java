package linkedlists;

import linkedlists.CustomLinkedList.LinkedNode;

// Problem Link: https://leetcode.com/problems/split-linked-list-in-parts/
// Solution Link: https://leetcode.com/problems/split-linked-list-in-parts/solutions/109296/java-c-clean-code/

// Approach: ALLOT Nodes EQUALLY [w/ one ORPHAN Node IF they are AVAILABLE]

public class KPartitionLinkedList {

    private LinkedNode[] parts;

    public LinkedNode[] compute(LinkedNode root, int k) {

        LinkedNode last = null, node = root;

        int length = 0, sizes, extra;
        int part = 0, size, count;

        parts = new LinkedNode[k];

        // COUNT Total Nodes
        while (node != null) {

            length += 1;
            node = node.next;
        }

        sizes = length / k; // EQUAL Alloting
        extra = length % k; // ORPHANED Nodes

        node = root; // Launch from ROOT

        while (node != null && part < k) {

            count = 0; // MEASURE the SUB-LIST

            parts[part] = node; // INSERT List

            // INSERT one ORPHAN Node per PART
            size = sizes + (extra > 0 ? 1 : 0);

            while (count < size) {

                last = node;
                node = node.next;

                count += 1;
            }

            last.next = null; // END this PART

            part += 1; // LOOP the next PART
            extra -= 1; // One EXTRA alloted
        }

        return parts; // Return ALL Allotments
    }
}