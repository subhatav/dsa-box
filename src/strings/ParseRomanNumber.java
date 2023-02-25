package strings;

// Problem Link: https://leetcode.com/problems/roman-to-integer/
// Solution Link: https://leetcode.com/problems/roman-to-integer/solutions/2632431/java-90-faster-solution/comments/1641369

public class ParseRomanNumber {

    public int compute(String str) {

        int last = str.length() - 1;

        int value = 0, backup = 0, number = 0;

        for (int index = last; index >= 0; index--) {

            switch (str.charAt(index)) {

                case 'M' -> value = 1000;
                case 'D' -> value = 500;
                case 'C' -> value = 100;
                case 'L' -> value = 50;
                case 'X' -> value = 10;
                case 'V' -> value = 5;
                case 'I' -> value = 1;
            }

            if (value < backup) {

                // Cases [I/X/C]
                number -= value;

            } else number += value;

            backup = value;
        }

        return number;
    }
}