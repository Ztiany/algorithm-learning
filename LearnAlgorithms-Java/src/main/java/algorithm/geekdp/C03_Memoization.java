package algorithm.geekdp;

import java.util.Arrays;

public class C03_Memoization {

    public static void main(String[] args) {
        TestHelper.test(new MemoizationSolution());
    }

    /**
     * 解法：带备忘录（Memoization）的递归。
     * <pre>
     *     该方案在递归的基础上，增加了备忘录来存储已经计算过的子问题的结果，避免重复计算，从而提高效率。
     *     具体来说，备忘录是一个数组，索引表示金额，值表示凑出该金额所需的最少硬币数量。
     *     每当计算一个新的金额时，首先检查备忘录中是否已经有结果，如果有则直接返回该结果，否则进行计算并将结果存入备忘录。
     * </pre>
     */
    private static class MemoizationSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -2);
            memo[0] = 0; // 其中 0 对应的结果也是 0，首先存在备忘录中
            return getMinCountsHelper(amount, coins, memo);
        }

        private int getMinCountsHelper(int amount, int[] coins, int[] memo) {
            int savedMinCount = memo[amount];
            if (savedMinCount != -2) {
                return savedMinCount;
            }

            int minCount = Integer.MAX_VALUE;
            for (int currentValue : coins) { // 遍历所有面值

                // 如果当前面值大于硬币总额，那么跳过
                if (currentValue > amount) {
                    continue;
                }

                // 使用当前面值，得到剩余硬币总额
                int rest = amount - currentValue;
                int restCount = getMinCountsHelper(rest, coins, memo);
                // 如果返回 -1，说明组合不可信，跳过
                if (restCount == -1) {
                    continue;
                }

                // 保留最小总额
                int totalCount = 1 + restCount;
                if (totalCount < minCount) {
                    minCount = totalCount;
                }
            }

            // 如果没有可用组合，返回 -1
            if (minCount == Integer.MAX_VALUE) {
                memo[amount] = -1;
                return -1;
            }

            memo[amount] = minCount; // 记录到备忘录
            return minCount; // 返回最小硬币数量
        }

    }

}