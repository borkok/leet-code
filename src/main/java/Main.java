public class Main {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;

        return findMaxProfit(prices, 0, prices.length-1);
    }

    private int findMaxProfit(int[] prices, int start, int end) {
        if (start >= end) return 0;

        int maxProfit = 0;
        for (int separator = start; separator <= end; separator++) {
            int profit = prices[separator] - prices[start];
            if(profit >= 0) {
                profit += findMaxProfit(prices,separator+1, end);
            }
            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
