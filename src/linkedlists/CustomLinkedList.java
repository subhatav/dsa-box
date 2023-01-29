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

        LinkedNode current = this.head;

        while (index-- > 0) current = current.next;

        return current;
    }

    public int getValueAt(int index) {

        if (index < 0 || index >= this.size) return -1;

        return getNodeAt(index).value;
    }

    protected void addAtHead(int value) {

        LinkedNode current = new LinkedNode(value);

        if (this.size == 0) {

            this.head = current;
            this.tail = current;

        } else {

            current.next = this.head;
            this.head = current;
        }

        this.size += 1;
    }

    protected void addAtTail(int value) {

        LinkedNode current = new LinkedNode(value);

        if (this.size == 0) {

            this.head = current;
            this.tail = current;

        } else {

            this.tail.next = current;
            current.next = null;
            this.tail = current;
        }

        this.size += 1;
    }

    public void addAt(int index, int value) {

        if (index < 0 || index > this.size) return;

        if (index == 0) addAtHead(value);
        else if (index == this.size) addAtTail(value);
        
        else {

            LinkedNode last = getNodeAt(index - 1);
            LinkedNode current = new LinkedNode(value);
            LinkedNode next = last.next;

            last.next = current;
            current.next = next;

            this.size += 1;
        }
    }

    protected void deleteFirst() {

        if (this.size == 0) return;

        if (this.size == 1) {

            this.head = null;
            this.tail = null;

        } else {

            LinkedNode last = this.head;
            LinkedNode next = last.next;

            last.next = null;
            this.head = next;
        }

        this.size -= 1;
    }

    protected void deleteLast() {

        if (this.size == 0) return;

        if (this.size == 1) {

            this.head = null;
            this.tail = null;

        } else {

            LinkedNode previous = getNodeAt(this.size - 2);

            previous.next = null;
            this.tail = previous;
        }

        this.size -= 1;
    }

    public void deleteAt(int index) {

        if (index < 0 || index >= this.size) return;

        if (index == 0) deleteFirst();
        else if (index == this.size - 1) deleteLast();
        
        else {

            LinkedNode last = getNodeAt(index - 1);
            LinkedNode current = last.next;
            LinkedNode next = last.next.next;

            current.next = null;
            last.next = next;

            this.size -= 1;
        }
    }
}