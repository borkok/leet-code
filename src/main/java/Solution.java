import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {

    private final Map<Pair, Integer> profitCache = new HashMap<>();

    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;
        return findMaxProfit(prices, 0, prices.length-1);
    }

    private int findMaxProfit(int[] prices, int start, int end) {
        Pair key = new Pair(start, end);
        if (profitCache.containsKey(key))   return profitCache.get(key);
        if (end - start == 1)               return cacheProfit(key, Math.max(prices[end] - prices[start], 0));

        int maxProfit = 0;
        for (int separator = start; separator <= end; separator++) {
            int profit = Math.max(prices[separator] - prices[start], 0);
            if (separator+1 < end) {
                profit += findMaxProfit(prices, separator + 1, end);
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
