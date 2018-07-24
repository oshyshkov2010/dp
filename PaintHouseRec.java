public class PaintHouseRec {
    public static int minCostRec(int[][] costs) {
        return minCostRec(costs, -1, -1);
    }

    private static int minCostRec(int[][] costs, int prevColor, int houseIndex) {
        // Last color
        if (houseIndex == costs.length ) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // Try all colors, except the previously selected
        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                min = Math.min(min, minCostRec(costs, color, houseIndex + 1));
            }
        }

        return houseIndex < 0 ? min : costs[houseIndex][prevColor] + min;
    }

    public static void main(String[] args) {
        int min = PaintHouseRec.minCostRec(new int[][]{{17, 2, 17}, {16, 16, 5}, {14, 3, 19}});
        System.out.println(min);
    }
}
