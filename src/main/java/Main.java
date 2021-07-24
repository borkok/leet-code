public class Main {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;

        int maxProfit = 0;
        int start=0;
        int end = prices.length-1;
        for (int i = start+1; i <= end; i++) {
            int profit = prices[i] - prices[0];
            if(profit > maxProfit)
                maxProfit = profit;
        }
        return maxProfit;
    }
}
