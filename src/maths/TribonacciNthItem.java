package maths;

// Problem Link: https://leetcode.com/problems/n-th-tribonacci-number/description/
// Solution Link: https://leetcode.com/problems/n-th-tribonacci-number/solutions/345236/java-c-python-easy-and-concise/

// Time Complexity: O(N); Space Complexity: O(1)

public class TribonacciNthItem {

    public int compute1(int n) {

        if (n < 2) return n;

        int a = 0, b = 1, c = 1, d;

        while ((n -= 1) >= 2) {

            d = a + b + c;

            a = b;
            b = c;
            c = d;
        }

        return c;
    }

    public int compute2(int n) {

        int series[] = { 0, 1, 1 };

        int index = 2, a, b, c, d;

        while ((index += 1) <= n) {

            a = series[0];
            b = series[1];
            c = series[2];
            d = a + b + c;

            series[index % 3] = d;
        }

        return series[n % 3];
    }
}
