package stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextSmallerNumber {

    public ArrayList<Integer> compute(ArrayList<Integer> nums, int size) {

        // Fill the default values as [-1] for the whole ArrayList of the NSNs
        ArrayList<Integer> nsns = new ArrayList<>(Collections.nCopies(size, -1));
        Stack<Integer> stack = new Stack<>();

        for (int index = 0; index < size; index++) {

            int number = nums.get(index);

            // Remove right-most numbers which are LARGER than "number"
            while (!stack.empty() && number < nums.get(stack.peek())) {

                // Save the CURRENT number as
                // NSN for the larger numbers
                nsns.set(stack.pop(), number);
            }

            stack.push(index);
        }

        return nsns;
    }
}
