public class Main {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;

        return findMaxProfit(prices, 0, prices.length-1);
    }

    private int findMaxProfit(int[] prices, int start, int end) {
        int maxProfit = 0;
        for (int rightIndex = start +1; rightIndex <= end; rightIndex++) {
            int profit = prices[rightIndex] - prices[start];
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
