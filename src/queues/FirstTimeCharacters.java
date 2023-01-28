package queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// GeeksForGeeks Link: https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Hash Map & Queue FIFO Technique; Time Complexity: O(N)

public class FirstTimeCharacters {
    
    public String compute(String characters) {

        Map<Character, Integer> counter = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        String answer = new String();

        for (char character : characters.toCharArray()) {

            if (counter.containsKey(character)) queue.remove(character);
            else queue.add(character);

            answer += (queue.isEmpty()) ? "#" : queue.peek();
            
            counter.merge(character, 1, (old, value) -> old + value);
        }

        return answer;
    }
}