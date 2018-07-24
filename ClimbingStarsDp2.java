public class ClimbingStarsDp2 {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int prevprev = cost[0];
        int prev = Math.min(cost[1], cost[0] + cost[1]);
        for (int i = 2; i < cost.length; i++) {
            int current = cost[i] + Math.min(prevprev, prev);
            prevprev = prev;
            prev = current;
        }

        return Math.min(prev, prevprev);
    }

    public static void main(String[] args) {
        int min = ClimbingStarsDp2.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(min);
    }
}
