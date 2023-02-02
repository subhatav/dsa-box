package stacks;

import java.util.Random;
import java.util.Stack;

// LeetCode Link: https://www.codingninjas.com/codestudio/problems/the-celebrity-problem_982769
// Solution Link: https://www.geeksforgeeks.org/the-celebrity-problem/

// Approach #1: Brute Force; Time Complexity: O(N^2); Space Complexity: O(N)
// Approach #2: Elimination with Stack; Time Complexity: O(3 * (N-1)); Space Complexity: O(N)
// Approach #3: Elimination with 2-Pointers; Time Complexity: O(N + N); Space Complexity: O(1)

/* 
    <1> If A knows B, then A cannot be a celebrity. Discard A, and B may be celebrity.
    <2> If A does not know B, then B cannot be a celebrity. Discard B, and A may be celebrity.
    <3> Repeat the above two steps till there is only one person remaining.
    <4> Ensure that the remaining person is a celebrity.
*/

public class IdentifyCelebrity {

    public int compute2(int capacity) {

        Stack<Integer> guests = new Stack<>();

        int person = -1;

        while (++person < capacity) guests.push(person);

        while (guests.size() >= 2) { // Performing <3>

            int guest1 = guests.pop(), guest2 = guests.pop();

            if (knows(guest1, guest2)) guests.push(guest2);
            else guests.push(guest1); // Running <1,2>
        }

        if (guests.empty()) return -1;

        return traverse(guests.pop(), capacity);
    }

    public int compute3(int capacity) {

        int left = 0, right = capacity - 1;

        while (left < right) { // Running <3>

            if (knows(left, right)) left += 1;
            else right -= 1; // Running <1,2>
        }

        return traverse(right, capacity);
    }

    protected int traverse(int celebrity, int capacity) {

        int person = -1;

        while (++person < capacity) {

            if (person != celebrity) { // Performing <4>

                if (knows(celebrity, person)) return -1;
                if (!knows(person, celebrity)) return -1;
            }
        }

        return celebrity;
    }

    private boolean knows(int person1, int person2) {

        // Implementation done by Problem
        return new Random().nextBoolean();
    }
}