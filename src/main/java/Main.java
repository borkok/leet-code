public class Main {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)   return 0;
        if(prices[1] - prices[0] < 0)   return 0;
        return prices[1] - prices[0];
        //return bruteForce(0, prices.length-1, prices);
    }
}
