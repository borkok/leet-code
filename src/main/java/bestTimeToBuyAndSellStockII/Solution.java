package bestTimeToBuyAndSellStockII;

public class Solution {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;

        int profit = 0;
        Phase currentPhase = Phase.buying();
        int lastDay = prices.length - 1;
        int buyingPrice = 0;
        for (int today = 0; today <= lastDay; today++) {
            int tomorrow = today + 1;
            if (currentPhase.isBuying()) {
                if (today != lastDay && prices[today] < prices[tomorrow]) {
                    //buy
                    buyingPrice = prices[today];
                    currentPhase.toggle();
                }
            } else {
                // currentPhase.isSelling()
                if (today == lastDay || prices[today] > prices[tomorrow]) {
                    //sell
                    profit += prices[today] - buyingPrice;
                    currentPhase.toggle();
                }
            }
        }
        return profit;
    }

    private static class Phase {
        enum PhaseName {
            I_WANT_TO_BUY,
            I_WANT_TO_SELL;

        }
        private PhaseName currentValue;

        static Phase buying() {
            return new Phase(PhaseName.I_WANT_TO_BUY);
        }

        private Phase(PhaseName name) {
            this.currentValue = name;
        }

        boolean isBuying() {
            return this.currentValue == PhaseName.I_WANT_TO_BUY;
        }

        void toggle() {
            PhaseName nextValue = isBuying() ? PhaseName.I_WANT_TO_SELL : PhaseName.I_WANT_TO_BUY;
            this.currentValue = nextValue;
        }
    }

}
