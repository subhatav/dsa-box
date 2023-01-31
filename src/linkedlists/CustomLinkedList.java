package linkedlists;

// LeetCode Link: https://leetcode.com/problems/design-linked-list/

public class CustomLinkedList {

    static class LinkedNode {

        int value = 0;
        LinkedNode next = null;

        LinkedNode(int value) { this.value = value; }
    }

    private LinkedNode head;
    private LinkedNode tail;

    private int size;

    public CustomLinkedList() {

        this.size = 0;

        this.head = null;
        this.tail = null;
    }

    protected LinkedNode getNodeAt(int index) {

        LinkedNode node = this.head;

        while (index-- > 0) node = node.next;

        return node;
    }

    public int getValueAt(int index) {

        if (index < 0 || index >= this.size) return -1;

        return getNodeAt(index).value;
    }

    protected void addAtHead(int value) {

        LinkedNode node = new LinkedNode(value);

        if (this.size == 0) {

            this.head = node;
            this.tail = node;

        } else {

            node.next = this.head;
            this.head = node;
        }

        this.size += 1;
    }

    protected void addAtTail(int value) {

        LinkedNode node = new LinkedNode(value);

        if (this.size == 0) {

            this.head = node;
            this.tail = node;

        } else {

            this.tail.next = node;
            node.next = null;
            this.tail = node;
        }

        this.size += 1;
    }

    public void addAt(int index, int value) {

        if (index < 0 || index > this.size) return;

        if (index == 0) addAtHead(value);
        else if (index == this.size) addAtTail(value);
        
        else {

            LinkedNode back = getNodeAt(index - 1);
            LinkedNode node = new LinkedNode(value);
            LinkedNode then = back.next;

            back.next = node;
            node.next = then;

            this.size += 1;
        }
    }

    protected void deleteFirst() {

        if (this.size == 0) return;

        if (this.size == 1) {

            this.head = null;
            this.tail = null;

        } else {

            LinkedNode back = this.head;
            LinkedNode then = back.next;

            back.next = null;
            this.head = then;
        }

        this.size -= 1;
    }

    protected void deleteLast() {

        if (this.size == 0) return;

        if (this.size == 1) {

            this.head = null;
            this.tail = null;

        } else {

            LinkedNode back = getNodeAt(this.size - 2);

            back.next = null;
            this.tail = back;
        }

        this.size -= 1;
    }

    public void deleteAt(int index) {

        if (index < 0 || index >= this.size) return;

        if (index == 0) deleteFirst();
        else if (index == this.size - 1) deleteLast();
        
        else {

            LinkedNode back = getNodeAt(index - 1);
            LinkedNode node = back.next;
            LinkedNode then = back.next.next;

            node.next = null;
            back.next = then;

            this.size -= 1;
        }
    }
}