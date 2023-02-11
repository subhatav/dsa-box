package backtracking;

// Problem Link: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/
// Solution Link: https://takeuforward.org/data-structure/m-coloring-problem/

// Approach: Use Backtracking Technique; Time Complexity: O(N^M), Space Complexity: O(N + N)

public class MColoringNodes {

    public boolean compute(boolean graph[][], int m, int n) {

        return paint(graph, new int[n], m, n, 0);
    }

    protected boolean paint(boolean graph[][], int[] nodes, int m, int n, int index) {

        if (index == n) return true; // Return when Nodes are PAINTED

        for (int color = 1; color <= m; color++) {

            if (safe(graph, nodes, n, index, color)) {

                nodes[index] = color; // Color paint the CURRENT Node

                // Do recursive call to EXTEND Coloring for NEXT Node
                if (paint(graph, nodes, m, n, index + 1)) return true;

                nodes[index] = 0; // Remove the Color of CURRENT Node
            }
        }

        return false;
    }

    private boolean safe(boolean[][] graph, int[] nodes, int n, int index, int color) {

        // Loop through ALL the Neighbours of CURRENT Node
        for (int neighbor = 0; neighbor < n; neighbor++) {

            boolean adjacent = graph[index][neighbor];
            boolean same = (color == nodes[neighbor]);

            // Check whether the ADJACENT Node
            // has SAME Color as CURRENT Color
            if (adjacent && same) return false;
        }

        return true;
    }
}