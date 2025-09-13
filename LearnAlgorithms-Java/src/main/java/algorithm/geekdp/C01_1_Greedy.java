package algorithm.geekdp;


public class C01_1_Greedy {

    public static void main(String[] args) {
        Tester.test(new Greedy());
    }

    /**
     * 解题方案：贪心算法（Greedy Algorithm）。
     * <pre>
     *      这个方案这段代码就是简单地从最大的面值开始尝试，每次都会把当前面值的硬币尽量用光，然后才会尝试下一种面值的货币。
     *      但是这样有个问题，就是只考虑了局部最优解，并不一定能得到全局最优解。比如面值是 4、3 的硬币，想要凑出金额 6，一
     *      开始使用 4 的硬币，结果就会发现无法凑出 6，而如果一开始使用 3 的硬币，就能凑出 6。
     * </pre>
     */
    static class Greedy implements CoinChangeProblem {

        @Override
        public int coinChange(int[] coins, int amount) {
            int rest = amount;
            int count = 0;

            for (int coin : coins) {
                int currentCount = rest / coin; // 计算当前面值最多能用多少个
                rest -= currentCount * coin; // 计算使用完当前面值后的余额
                count += currentCount; // 增加当前面额用量
                if (rest == 0) {
                    return count;
                }
            }

            // 如果到这里说明无法凑出总价，返回 -1。
            return -1;
        }

    }

}