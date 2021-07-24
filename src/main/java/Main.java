public class Main {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;

        return findMaxProfit(prices, 0, prices.length-1);
    }

    private int findMaxProfit(int[] prices, int start, int end) {
        if (start >= end) return 0;

        int maxProfit = 0;
        for (int rightIndex = start; rightIndex <= end; rightIndex++) {
            int profit = prices[rightIndex] - prices[start];
            if(profit >= 0) {
                profit += findMaxProfit(prices,rightIndex+1, end);
            }
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
