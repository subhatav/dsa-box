package caches;

import java.util.HashMap;
import java.util.Map;

// Problem Link: https://leetcode.com/problems/lru-cache/
// Solution Link: https://leetcode.com/problems/lru-cache/solutions/45939/laziest-implementation-java-s-linkedhashmap-takes-care-of-everything/

// All Approaches: Time Complexity: O(1), Space Complexity: O(N)

// Approach #1: Use Doubly Linked List & HashMap Data Structures

public class LeastRecentlyUsed1 {

    static class DoublyNode {

        int key, value;
        DoublyNode last, next;

        DoublyNode() { this(-1, -1); }

        DoublyNode(int key, int value) {

            this.key = key;
            this.value = value;
        }
    }

    // Store the LOCATIONS of ALL D-Nodes
    private Map<Integer, DoublyNode> map;

    // Serves as the MARKER Nodes
    private DoublyNode head, tail;

    private int count, capacity;

    public LeastRecentlyUsed1(int capacity) {

        map = new HashMap<>();

        head = new DoublyNode();
        tail = new DoublyNode();
        
        this.count = 0;
        this.capacity = capacity;

        head.next = tail;
        tail.last = head;
    }

    public int get(int key) {

        DoublyNode node = map.get(key);

        if (node == null) return -1;

        update(node); // MARK the NODE

        return node.value;
    }

    public void put(int key, int value) {

        DoublyNode node = map.get(key);

        if (node == null) {

            node = new DoublyNode(key, value);

            map.put(key, node);
            add(node);

            count += 1;

        } else {

            node.value = value;
            update(node);
        }

        if (count > capacity) {

            node = tail.last;

            map.remove(node.key);
            delete(node);

            count -= 1;
        }
    }

    // MARKS the Node as RECENTLY ACCESSED
    protected void update(DoublyNode node) {

        delete(node); // DELETE the Node
        add(node); // TAKE it to the TOP
    }

    // ADDS the given Node at the TOP
    private void add(DoublyNode node) {

        DoublyNode then = head.next;

        head.next = node;
        node.last = head;

        node.next = then;
        then.last = node;
    }

    // DELETES the given Node from List
    private void delete(DoublyNode node) {

        DoublyNode back = node.last;
        DoublyNode then = node.next;

        back.next = then;
        then.last = back;
    }
}