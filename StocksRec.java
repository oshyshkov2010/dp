public class StocksRec {
    public int maxProfit(int[] prices, int fee) {
        return maxProfit(prices, fee, 0);
    }

    private int maxProfit(int[] prices, int fee, int start) {
        if (start >= prices.length) return 0;

        int max = 0;
        for (int end = start + 1; end < prices.length; end++) {
            int nextMax = maxProfit(prices, fee, end);
            int profit = prices[end] - prices[start] - fee;
            max = Math.max(max, nextMax);
            if (profit > 0) {
                nextMax = maxProfit(prices, fee, end + 1);
                max = Math.max(max, nextMax + profit);
            }
        }

        return max;
    }
}
