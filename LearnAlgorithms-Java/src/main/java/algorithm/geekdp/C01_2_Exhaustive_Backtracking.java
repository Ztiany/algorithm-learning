package algorithm.geekdp;

public class C01_2_Exhaustive_Backtracking {


    public static void main(String[] args) {
        TestHelper.test(new BacktrackingSolution());
        TestHelper.test(new ExhaustiveBacktrackingSolution());
    }

    /**
     * 解法：回溯（Backtracking）。
     * <pre>
     *     该方案通过递归的方式，尝试每一种面值的硬币数量，从最多的数量开始尝试，逐步减少当前面值的硬币数量，然后递归地尝试下一个面值。
     *     如果在某个面值上无法凑出总金额，就会回溯到上一个面值，减少它的数量，继续尝试。这种方法确保了所有可能的组合都会被尝试到，
     *     因此能够找到最优解。
     *
     *     但是可能找不到最优解的情况是因为没有尝试所有面值的排列组合，比如面值是 1,7, 10，金额是 14，如果先尝试 1，那么就会用 14 个 1
     *     面值的硬币，结果是 14 个硬币；如果先尝试 7，那么就会用 2 个 7 面值的硬币，结果是 2 个硬币，显然后者更优。
     * </pre>
     */
    private static class BacktrackingSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            return getMinCoinCountOfValue(amount, coins, 0);
        }

        @SuppressWarnings("DuplicatedCode")
        private int getMinCoinCountOfValue(int total, int[] values, int valueIndex/* 表示尝试到第几个面值的硬币 */) {
            int valueCount = values.length;
            if (valueIndex == valueCount) {
                return Integer.MAX_VALUE;
            }

            int minResult = Integer.MAX_VALUE; // MAX_VALUE 表示无解
            int currentValue = values[valueIndex];
            int maxCount = total / currentValue; // 当前面值最多能用多少个

            for (int count = maxCount; count >= 0; count--) {// 从最多的面值开始尝试
                int rest = total - count * currentValue;

                // 如果 rest 为 0，表示余额已除尽，组合完成
                if (rest == 0) {
                    minResult = Math.min(minResult, count);
                    break;
                }

                // 否则尝试用剩余面值求当前余额的硬币总数，valueIndex + 1 表示尝试下一个面值
                int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);

                // 如果后续没有可用组合
                if (restCount == Integer.MAX_VALUE) {
                    // 如果当前面值已经为 0，返回 -1 表示尝试失败，即当前面值无法凑出总价
                    if (count == 0) {
                        break;
                    }
                    // 否则尝试把当前面值的数量减 1，继续尝试，这也是一种回溯的思想
                    continue;
                }

                // 如果后续有可用组合，计算总的硬币数量
                minResult = Math.min(minResult, count + restCount);
            }

            return minResult;
        }

    }

    /**
     * 解法：暴力穷举 + 回溯（Exhaustive Search + Backtracking）。
     * <pre>
     *     getMinCoinCountOfValue 针对特定的面值顺序，计算最少硬币数。
     *     getMinCoinCountLoop 用于生成所有面值的排列组合，确保不会遗漏任何一种可能性。
     * </pre>
     */
    private static class ExhaustiveBacktrackingSolution implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            return getMinCoinCountLoop(amount, coins, 0);
        }

        @SuppressWarnings("DuplicatedCode")
        private int getMinCoinCountOfValue(int total, int[] values, int valueIndex/* 表示尝试到第几个面值的硬币 */) {
            int valueCount = values.length;
            if (valueIndex == valueCount) {
                return Integer.MAX_VALUE;
            }

            int minResult = Integer.MAX_VALUE; // MAX_VALUE 表示无解
            int currentValue = values[valueIndex];
            int maxCount = total / currentValue; // 当前面值最多能用多少个

            for (int count = maxCount; count >= 0; count--) {// 从最多的面值开始尝试
                int rest = total - count * currentValue;

                // 如果 rest 为 0，表示余额已除尽，组合完成
                if (rest == 0) {
                    minResult = Math.min(minResult, count);
                    break;
                }

                // 否则尝试用剩余面值求当前余额的硬币总数，valueIndex + 1 表示尝试下一个面值
                int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);

                // 如果后续没有可用组合
                if (restCount == Integer.MAX_VALUE) {
                    // 如果当前面值已经为 0，返回 -1 表示尝试失败，即当前面值无法凑出总价
                    if (count == 0) {
                        break;
                    }
                    // 否则尝试把当前面值的数量减 1，继续尝试，这也是一种回溯的思想
                    continue;
                }

                // 如果后续有可用组合，计算总的硬币数量
                minResult = Math.min(minResult, count + restCount);
            }

            return minResult;
        }

        /**
         * 该方法是为了穷举所有面值的排列组合，确保不会遗漏任何一种可能性。因为无法保证 values 数组中面值的顺序是最优的，所以需要通过排列组合来
         * 尝试所有可能的顺序。通过递归交换数组中的元素，生成所有可能的排列，然后对每一种排列调用 getMinCoinCountOfValue 方法来计算最少硬币
         * 数。
         */
        private int getMinCoinCountLoop(int total, int[] values, int valueIndex) {
            int minCount = Integer.MAX_VALUE;
            int valueCount = values.length;

            if (valueIndex == valueCount) {
                return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
            }

            for (int i = valueIndex; i <= valueCount - 1; i++) {
                // valueIndex 和 i 交换
                int t = values[valueIndex];
                values[valueIndex] = values[i];
                values[i] = t;

                minCount = Math.min(minCount, getMinCoinCountLoop(total, values, valueIndex + 1)); // 考虑后一位

                // 回溯：换回 valueIndex 和 i，下一次循环 valueIndex 位置的数再和后面的数交换
                t = values[valueIndex];
                values[valueIndex] = values[i];
                values[i] = t;
            }

            return minCount;
        }

    }

}