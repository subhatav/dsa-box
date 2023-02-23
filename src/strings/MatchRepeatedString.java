package strings;

// Problem Link: https://leetcode.com/problems/repeated-string-match/
// Solution Link: https://leetcode.com/problems/repeated-string-match/solutions/108086/java-solution-just-keep-building-oj-missing-test-cases/

// Approach: Use Rabin-Karp Algorithm for Pattern Searching
// Algorithm Link: https://www.programiz.com/dsa/rabin-karp-algorithm

// Best/Average Time Complexity: O(N - M + 1), or O(N + M), Worst Time Complexity: O(N * M)

public class MatchRepeatedString {

    private static int BASE = 26;

    public int compute(String source, String target) {

        StringBuilder repeated = new StringBuilder();
        int count = 0;

        while (repeated.length() < target.length()) {

            repeated.append(source);
            count += 1;
        }

        if (repeated.toString().contains(target)) return count;

        repeated.append(source);
        if (repeated.toString().contains(target)) return (count + 1);

        repeated.append(repeated);
        if (contains(repeated.toString(), target)) return (count * 2);

        return -1;
    }

    private boolean contains(String text, String pattern) {

        int textSize = text.length(), patternSize = pattern.length();
        long basePower = 1, textHash = 0, patternHash = 0;

        for (int index = 0; index < patternSize; index += 1) {

            basePower = (index > 0) ? (basePower * BASE) : 1;

            textHash = (textHash * BASE) + (text.charAt(index) - 'a');
            patternHash = (patternHash * BASE) + (pattern.charAt(index) - 'a');
        }

        for (int index = patternSize; index < textSize; index += 1) {

            int start = index - patternSize;

            String portion = text.substring(start, index);
            if (textHash == patternHash && portion.equals(pattern)) return true;

            textHash -= basePower * (text.charAt(start) - 'a');
            textHash = (textHash * BASE) + (text.charAt(index) - 'a');
        }

        String portion = text.substring(textSize - patternSize, textSize);
        if (textHash == patternHash && portion.equals(pattern)) return true;

        return false;
    }
}