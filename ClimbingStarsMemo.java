import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStarsMemo {
    public static int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> cache = new HashMap<>();
        return minCostClimbingStairsRec(cost, -1, cache);
    }

    private static int minCostClimbingStairsRec(int[] cost, int index, Map<Integer, Integer> cache) {
        if (index >= cost.length) {
            return 0;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int oneStepCost = minCostClimbingStairsRec(cost, index + 1, cache);
        int twoStepsCost = minCostClimbingStairsRec(cost, index + 2, cache);

        int min = Math.min(oneStepCost, twoStepsCost);
        if (index < 0) {
            return min;
        }

        int thisCost = cost[index] + min;
        cache.put(index, thisCost);
        return thisCost;
    }

    public static void main(String[] args) {
        int min = ClimbingStarsMemo.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(min);
    }
}
