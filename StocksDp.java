public class StocksDp {
    public int maxProfit(int[] prices, int fee) {
        int[] cache = new int[prices.length];
        int max = 0;
        for (int end = 1; end < prices.length; end++) {
            cache[end] = cache[end - 1];
            for (int start = end - 1; start >= 0; start--) {
                int prevProfit = 0;
                if (start > 0) {
                    prevProfit = cache[start - 1];
                }

                cache[end] = Math.max(cache[end], prices[end] - prices[start] - fee + prevProfit);
            }
            max= Math.max(max, cache[end]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new StocksDp().maxProfit(new int[]{4,5,2,4,3,3,1,2,5,4}, 1));
    }
}
