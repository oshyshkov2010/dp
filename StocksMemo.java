public class StocksMemo {
    private static final int INVALID_PROFIT = -1;

    public int maxProfit(int[] prices, int fee) {
        int[] cache = new int[prices.length];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = INVALID_PROFIT;
        }

        return maxProfit(prices, fee, 0, cache);
    }

    private int maxProfit(int[] prices, int fee, int start, int[] cache) {
        if (start >= prices.length) return 0;

        if (cache[start] != INVALID_PROFIT) {
            return cache[start];
        }

        int max = 0;
        for (int end = start + 1; end < prices.length; end++) {
            int nextMax = maxProfit(prices, fee, end, cache);
            int profit = prices[end] - prices[start] - fee;

            if (profit > 0) {
                nextMax = maxProfit(prices, fee, end + 1, cache);
                nextMax += profit;
            }
            max = Math.max(max, nextMax);
        }

        cache[start] = max;

        return max;
    }
}
