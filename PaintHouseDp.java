public class PaintHouseDp {
    public static int minCostDp(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[][] cache = new int[costs.length][3];
        for (int houseIndex = 0; houseIndex < costs.length; houseIndex++) {
            for (int color = 0; color < 3; color++) {
                if (houseIndex == 0) {
                    // Since we don't have previous subtask, the costs for the first house
                    // is solution for the first task
                    cache[houseIndex][color] = costs[houseIndex][color];
                } else {
                    cache[houseIndex][color] = Integer.MAX_VALUE;
                }
            }
        }

        for (int houseIndex = 1; houseIndex < costs.length; houseIndex++) {
            for (int prevColor = 0; prevColor < 3; prevColor++) {
                for (int currentColor = 0; currentColor < 3; currentColor++) {
                    if (prevColor != currentColor) {
                        // It is either cache result of the best solution for previous house + cost for current house
                        // or cost that we already calculated for another previous color.
                        cache[houseIndex][currentColor] = Math.min(cache[houseIndex][currentColor],
                                cache[houseIndex - 1][prevColor] + costs[houseIndex][currentColor]);
                    }
                }
            }
        }

        return Math.min(cache[cache.length - 1][0], Math.min(cache[cache.length - 1][1], cache[cache.length - 1][2]));
    }

    public static void main(String[] args) {
        int min = PaintHouseDp.minCostDp(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println(min);
    }
}
