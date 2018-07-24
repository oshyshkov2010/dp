public class ClimbingStarsRec {
    public static int minCostClimbingStairs(int[] cost) {
        return minCostClimbingStairsRec(cost, -1);
    }

    private static int minCostClimbingStairsRec(int[] cost, int index) {
        if (index >= cost.length) {
            return 0;
        }

        int oneStepCost = minCostClimbingStairsRec(cost, index + 1);
        int twoStepsCost = minCostClimbingStairsRec(cost, index + 2);

        int min = Math.min(oneStepCost, twoStepsCost);
        return index >= 0 ? cost[index] + min : min;
    }

    public static void main(String[] args) {
        int min = ClimbingStarsRec.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(min);
    }
}
