package algorithm.geekdp;

import java.util.ArrayList;
import java.util.Collections;

public class C02_Recursion {

    public static void main(String[] args) {
        Tester.test(new RecursionSolution());
        Tester.test(new RecursionSolution2());
    }

    /**
     * 解题方案：递归（Recursion）。
     * <pre>
     *     该方案通过递归的方式，尝试每一种面值的硬币数量，从 0 个开始尝试，逐步增加当前面值的硬币数量，然后递归地尝试下一个面值。
     *     如果在某个面值上无法凑出总金额，就会回溯到上一个面值，增加它的数量，继续尝试。这种方法确保了所有可能的组合都会被尝试到，
     *     因此能够找到最优解。
     *
     *     递归：用同样的逻辑去解决子问题，直到子问题可以直接解决为止。
     * </pre>
     */
    private static class RecursionSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(coins.length, 0)); // 初始值(0,0)

            ArrayList<ArrayList<Integer>> coinCombinations = new ArrayList<>(); // 存储所有组合
            getMinCountsHelper(amount, coins, initialCounts, coinCombinations); // 求解所有组合（不去重）

            return getMinimumHelper(coinCombinations); // 输出答案
        }

        private int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {
            // 如果没有可用组合，返回-1
            if (combinations.isEmpty()) {
                return -1;
            }

            int minCount = Integer.MAX_VALUE;
            for (ArrayList<Integer> counts : combinations) {
                int total = 0; // 求当前组合的硬币总数
                for (int count : counts) {
                    total += count;
                }

                // 保留最小的
                if (total < minCount) {
                    minCount = total;
                }
            }

            return minCount;
        }

        private void getMinCountsHelper(
                int total,
                int[] coins,
                ArrayList<Integer> currentCounts,
                ArrayList<ArrayList<Integer>> combinations
        ) {
            if (0 == total) { // 如果余额为 0，说明当前组合成立，将组合加入到待选数组中
                combinations.add(new ArrayList<>(currentCounts));
                return;
            }

            int valueLength = coins.length;
            for (int i = 0; i < valueLength; i++) { // 遍历所有面值
                int currentValue = coins[i];
                if (currentValue > total) { // 如果面值大于当前总额，直接跳过
                    continue;
                }

                // 否则在当前面值数量组合上的对应位置加 1
                ArrayList<Integer> newCounts = new ArrayList<>(currentCounts);
                newCounts.set(i, newCounts.get(i) + 1);
                int rest = total - currentValue;

                // 遍历所有面值然后调用自己：即每次任意拿一个，然后递归地去解决剩下的额度。
                getMinCountsHelper(rest, coins, newCounts, combinations); // 求解剩余额度所需硬币数量
            }
        }

    }

    /**
     * 解题方案：递归（Recursion）。
     * <pre>
     *     该方案通过递归的方式，尝试每一种面值的硬币，减去当前面值后递归地计算剩余金额所需的最少硬币数量。
     *     如果在某个面值上无法凑出总金额，就会跳过该面值，继续尝试下一个面值。这种方法确保了所有可能的组合都会被尝试到，
     *     因此能够找到最优解。
     * </pre>
     * 可见用递归来解决问题，思路是非常清晰的，且代码非常简洁。不过存在一个问题，就是效率比较低，因为存在大量的重复计算。
     */
    private static class RecursionSolution2 implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            // 如果余额为0，说明当前组合成立，将组合加入到待选数组中
            if (0 == amount) {
                return 0;
            }

            int minCount = Integer.MAX_VALUE;
            for (int currentValue : coins) { // 遍历所有面值
                // 如果当前面值大于硬币总额，那么跳过
                if (currentValue > amount) {
                    continue;
                }

                int rest = amount - currentValue; // 使用当前面值，得到剩余硬币总额
                int restCount = coinChange(coins, rest);

                // 如果返回 -1，说明组合不可信，跳过
                if (restCount == -1) {
                    continue;
                }

                int totalCount = 1 + restCount; // 保留最小总额
                if (totalCount < minCount) {
                    minCount = totalCount;
                }
            }

            // 如果没有可用组合，返回 -1
            if (minCount == Integer.MAX_VALUE) {
                return -1;
            }

            return minCount; // 返回最小硬币数量
        }
    }

}
