package greedy;

// Problem Link: https://www.codingninjas.com/codestudio/problems/975277
// Solution Link: https://takeuforward.org/data-structure/find-minimum-number-of-coins/

// Approach: Use Greedy Technique; Time Complexity: O(N), where N == Value of "amount"

public class MinimumCoins {

    public int compute(int amount) {

        int coins[] = { 1000, 500, 100, 50, 20, 10, 5, 2, 1 };

        int purse = 0;

        for (int coin : coins) {

            while (coin <= amount) {

                amount -= coin;
                purse += 1;
            }
        }

        return purse;
    }
}
