import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    private Map<Pair, Integer> profitCache;
    private int[] prices;

    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;
        profitCache = new HashMap<>();
        this.prices = prices;
        int end = cutOffDescendingTail();
        return findMaxProfit(0, end);
    }

    private int cutOffDescendingTail() {
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > prices[i-1]) return i;
        }
        return 0;
    }

    private int findMaxProfit(int start, int end) {
        if (start >= end) return 0;
        Pair key = new Pair(start, end);
        if (profitCache.containsKey(key))   return profitCache.get(key);
        if (end - start == 1)               return cacheProfit(key, Math.max(prices[end] - prices[start], 0));

        int maxProfit = 0;
        for (int separator = start; separator <= end; separator++) {
            //left part profit
            int profit = Math.max(prices[separator] - prices[start], 0);
            //has right part at least 2 elements
            if (separator+1 < end) {
                //calculate and add right part profit
                profit += findMaxProfit(separator + 1, end);
            }
            maxProfit = Math.max(profit, maxProfit);
        }
        return cacheProfit(key, maxProfit);
    }

    private int cacheProfit(Pair key, int profit) {
        profitCache.put(key, profit);
        return profit;
    }

    private static class Pair {
        int left;
        int right;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return left == pair.left && right == pair.right;
        }

        public int hashCode() {
            return Objects.hash(left, right);
        }
    }
}
