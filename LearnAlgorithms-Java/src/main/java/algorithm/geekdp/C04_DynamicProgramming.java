package algorithm.geekdp;

import java.util.Arrays;

public class C04_DynamicProgramming {

    public static void main(String[] args) {
        Tester.test(new DynamicProgrammingSolution());
        Tester.test(new DynamicProgrammingSimplifiedSolution());
    }

    /**
     * 解法：动态规划
     * <pre>
     *     动态规划即从小问题的解，推导出大问题的解。这与递归的思路类似，但递归是自顶向下，而动态规划是自底向上。
     *     动态规划的核心是状态转移方程，即如何从子问题的解，推导出当前问题的解。
     * </pre>
     */
    private static class DynamicProgrammingSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1]; // 创建备忘录
            Arrays.fill(memo, -1); // 默认都设置为无解
            memo[0] = 0; // 初始化状态

            // 为什么从 1 跌倒到 amount，因为要计算 amount 内所有子问题的解。
            for (int subAmount = 1; subAmount <= amount; subAmount++) {

                // 初始值为无解，因为就算全部使用 1 元硬币，也不可能超过 amount 个，所以 amount + 1 是无解的标志。
                int minCount = amount + 1;

                for (int currentValue : coins) {
                    // 如果当前面值大于硬币总额，那么跳过
                    if (currentValue > subAmount) {
                        continue;
                    }

                    // 使用当前面值，得到剩余硬币总额
                    int rest = subAmount - currentValue;

                    // 查找剩余硬币总额的最优解
                    int restCount = memo[rest];
                    // 如果返回-1，说明组合不可信，跳过，初始值都是 -1 的，除了 memo[0]，因此最终会把问题分解到 memo[0]。
                    if (restCount == -1) {
                        continue;
                    }

                    // 保留最小总额
                    int kCount = 1 + restCount;
                    if (kCount < minCount) {
                        minCount = kCount;
                    }
                }

                // 如果是可用组合，记录结果
                if (minCount != amount + 1) {
                    memo[subAmount] = minCount;
                }
            }

            return memo[amount];
        }
    }

    /**
     * 解法：动态规划（简化版）
     * <pre>
     *     这个解法与上面的解法是等价的，只是写法更简洁一些。
     * </pre>
     */
    private static class DynamicProgrammingSimplifiedSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1]; // 创建备忘录
            Arrays.fill(memo, amount + 1); // 默认都设置为无解
            memo[0] = 0; // 初始状态：0 元需要 0 个硬币

            // 为什么从 1 跌倒到 amount，因为要计算 amount 内所有子问题的解。
            for (int subAmount = 1; subAmount < amount + 1; subAmount++) {
                for (int coin : coins) {
                    if (subAmount - coin < 0) {
                        continue;
                    }
                    // 精华在于 memo[subAmount - coin] + 1，subAmount - coin 即表示使用当前面值 coin 后，剩余的金额所需的最小硬币数，加 1 表示加上当前使用的这个 coin。
                    memo[subAmount] = Math.min(memo[subAmount], memo[subAmount - coin] + 1); // 作出决策
                }
            }

            return memo[amount] == amount + 1 ? -1 : memo[amount];
        }
    }

}