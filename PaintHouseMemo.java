public class PaintHouseMemo {
    public static int minCostRec(int[][] costs) {
        int[][] cache = new int[costs.length][3];
        return minCostRec(costs, -1, -1, cache);
    }

    private static int minCostRec(int[][] costs, int prevColor, int houseIndex, int[][] cache) {
        // Last color
        if (houseIndex == costs.length ) {
            return 0;
        }

        // If it's not a root and we have cached value
        if (houseIndex >= 0 && cache[houseIndex][prevColor] > 0) {
            return cache[houseIndex][prevColor];
        }

        int min = Integer.MAX_VALUE;
        // Try all colors, except the previously selected
        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                min = Math.min(min, minCostRec(costs, color, houseIndex + 1, cache));
            }
        }

        // Save min value to the cache
        if (houseIndex >= 0) {
            cache[houseIndex][prevColor] = costs[houseIndex][prevColor] + min;
        }
        return houseIndex < 0 ? min : cache[houseIndex][prevColor];
    }

    public static void main(String[] args) {
        int min = PaintHouseMemo.minCostRec(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println(min);
    }
}
