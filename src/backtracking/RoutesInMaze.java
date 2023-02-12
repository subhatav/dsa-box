package backtracking;

import java.util.ArrayList;
import java.util.List;

// Problem Link: https://www.codingninjas.com/codestudio/problems/758966
// Solution Link: https://takeuforward.org/data-structure/rat-in-a-maze/

// Time Complexity: O(4^(N * N)) == Every Cell has 4 Possible Directions
// Space Complexity: O(N * N) == Maximum Depth of the Recursion Tree

public class RoutesInMaze {

    private List<List<Integer>> routes;

    public List<List<Integer>> compute(int[][] maze, int n) {

        routes = new ArrayList<>();

        maze[0][0] = -1; // [-1] == Cell is VERIFIED

        path(maze, n, 0, 0);

        return routes;
    }

    protected void path(int[][] maze, int n, int x, int y) {

        // Check whether the TARGET Cell is REACHED
        if (x == n - 1 && y == n - 1) mark(maze, n);

        else {

            int backup;

            // Move the Rat LEFT-wards WHEN possible
            if ((y - 1) >= 0 && maze[x][y - 1] == 1) {

                backup = maze[x][y - 1];

                // Sign as VERIFIED
                // and EXTEND Route
                maze[x][y - 1] = -1;
                path(maze, n, x, y - 1);

                maze[x][y - 1] = backup;
            }

            // Move the Rat RIGHT-wards IF possible
            if ((y + 1) < n && maze[x][y + 1] == 1) {

                backup = maze[x][y + 1];

                // Sign as VERIFIED
                // and EXTEND Route
                maze[x][y + 1] = -1;
                path(maze, n, x, y + 1);

                maze[x][y + 1] = backup;
            }

            // Move the Rat UP-wards WHEN plausible
            if ((x - 1) >= 0 && maze[x - 1][y] == 1) {

                backup = maze[x - 1][y];

                // Sign as VERIFIED
                // and EXTEND Route
                maze[x - 1][y] = -1;
                path(maze, n, x - 1, y);

                maze[x - 1][y] = backup;
            }

            // Move the Rat DOWN-wards IF possible
            if ((x + 1) < n && maze[x + 1][y] == 1) {

                backup = maze[x + 1][y];

                // Sign as VERIFIED
                // and EXTEND Route
                maze[x + 1][y] = -1;
                path(maze, n, x + 1, y);

                maze[x + 1][y] = backup;
            }
        }
    }

    private void mark(int[][] maze, int n) {

        // List "route" == Each ROW of the Maze
        List<Integer> route = new ArrayList<>();

        for (int i = 0; i < n; i++)

            for (int j = 0; j < n; j++) {

                // ADD the Route, IF it is VERIFIED
                route.add(maze[i][j] == -1 ? 1 : 0);
            }

        routes.add(route); // ADD the ROW to Routes
    }
}