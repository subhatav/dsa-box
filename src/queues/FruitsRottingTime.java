package queues;

import java.util.LinkedList;
import java.util.Queue;

// Problem Link: https://leetcode.com/problems/rotting-oranges/
// Solution Link: https://leetcode.com/problems/rotting-oranges/solutions/238681/java-clean-bfs-solution-with-comments/

// Approach: Breadth-First-Searching with Queue FIFO Technique
// Time Complexity: O((M * N) * 4), Space Complexity: O(M * N)

public class FruitsRottingTime {

    public int compute(int[][] basket) {

        Queue<int[]> rotten = new LinkedList<>();

        int horizontal[] = { 0, 0, 1, -1 };
        int vertical[] = { 1, -1, 0, 0 };

        int rows = basket.length;
        int columns = basket[0].length;

        int fresh = 0, time = 0, sides = 4;

        for (int row = 0; row < rows; row++) {

            for (int column = 0; column < columns; column++) {

                int[] fruit = new int[] { row, column };

                // Records the existing Rotten Fruits from Basket
                if (basket[row][column] == 2) rotten.offer(fruit);
                // Counts the existing Fresh Fruits in Basket
                else if (basket[row][column] == 1) fresh += 1;
            }
        }

        // No Fresh Fruits are left
        if (fresh == 0) return time;

        while (!rotten.isEmpty() && fresh > 0) {

            int wasted = rotten.size();

            for (int count = 0; count < wasted; count++) {

                int[] centre = rotten.poll();

                // Spread the Rotting in four Directions
                for (int side = 0; side < sides; side++) {

                    int x = centre[0] + horizontal[side];
                    int y = centre[1] + vertical[side];

                    if (x < 0 || y < 0) continue;
                    if (x >= rows || y >= columns) continue;

                    if (basket[x][y] == 0) continue;
                    if (basket[x][y] == 2) continue;

                    basket[x][y] = 2;

                    rotten.offer(new int[] { x, y });

                    fresh -= 1;
                }
            }

            time += 1;
        }

        return (fresh == 0) ? time : -1;
    }
}
