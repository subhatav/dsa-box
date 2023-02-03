package arrays;

// Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Approach #1: Brute Force; Time Complexity: O(N^2)
// Approach #2: Traverse & Check; Time Complexity: O(N)

public class TradeStocks {

    public int compute(int[] prices) {

        int profit = 0, buy = prices[0];

        for (int price : prices) {

            if (price > buy) profit = Math.max(profit, price - buy);
            else if (price < buy) buy = price;
        }

        return profit;
    }
}