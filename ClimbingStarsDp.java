public class ClimbingStarsDp {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int[] cache = new int[cost.length];
        cache[0] = cost[0];
        cache[1] = Math.min(cost[1], cost[0] + cost[1]);
        for (int i = 2; i < cost.length; i++) {
            cache[i] = cost[i] + Math.min(cache[i - 1], cache[i - 2]);
        }

        return cache[cache.length - 1];
    }

    public static void main(String[] args) {
        int min = ClimbingStarsDp.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(min);
    }
}
