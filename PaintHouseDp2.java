public class PaintHouseDp2 {
    public static int minCostDp(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int[] cache = new int[3];
        for (int houseIndex = 0; houseIndex < costs.length; houseIndex++) {
            int prevColor0 = cache[0];
            int prevColor1 = cache[1];
            int prevColor2 = cache[2];
            cache[0] = costs[houseIndex][0] + Math.min(prevColor1, prevColor2);
            cache[1] = costs[houseIndex][1] + Math.min(prevColor0, prevColor2);
            cache[2] = costs[houseIndex][2] + Math.min(prevColor0, prevColor1);
        }

        return Math.min(cache[0], Math.min(cache[1], cache[2]));
    }

    public static void main(String[] args) {
        int min = PaintHouseDp2.minCostDp(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println(min);
    }
}
