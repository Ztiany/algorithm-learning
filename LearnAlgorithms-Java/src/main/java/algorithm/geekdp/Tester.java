package algorithm.geekdp;

import java.util.Arrays;

class Tester {

    public static void test(CoinChangeProblem problem) {
        System.out.println("================================");
        System.out.println("Testing " + problem.getClass().getSimpleName());
        test(problem, new int[]{5, 3}, 11);
        test(problem, new int[]{5, 2, 1}, 12);
        test(problem, new int[]{4, 3}, 6);
        test(problem, new int[]{1, 7, 10}, 14);
        System.out.println("================================");
    }

    private static void test(CoinChangeProblem problem, int[] coins, int amount) {
        System.out.println("--------------------------------");
        System.out.println("coins: " + Arrays.toString(coins) + ", amount: " + amount);
        long start = System.currentTimeMillis();
        int result = problem.coinChange(coins, amount);
        System.out.printf("result: %d, take: %dms\n", result, System.currentTimeMillis() - start);
    }

}
