package maths;

// Problem Link: https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1
// Solution Link: https://stackoverflow.com/a/20124734

// Approach: ["src" --> "dest"] is SAME as ["src" --> "aux"] + ["aux" --> "dest"]

public class SolveTowerOfHanoi {

    public long compute(int disk, int src, int dest, int aux) {

        long count = 0;

        if (disk > 0) {

            count += compute(disk - 1, src, aux, dest);
            count += 1;
            count += compute(disk - 1, aux, dest, src);
        }

        return count;
    }
}