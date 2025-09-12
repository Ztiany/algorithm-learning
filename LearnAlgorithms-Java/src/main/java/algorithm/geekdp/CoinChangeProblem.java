package algorithm.geekdp;

/**
 * 问题描述：
 * <pre>
 *  给定 n 种不同面值的硬币，分别记为 c[0], c[1], c[2], … c[n]，同时还有一个总金额 k，编写一个函数计算出
 *  最少需要几枚硬币凑出这个金额 k，每种硬币的个数不限，且如果没有任何一种硬币组合能组成总金额时，返回 -1。
 *
 *  示例 1：
 *      输入：c[0]=1, c[1]=2, c[2]=5, k=12
 *      输出：3
 *      说明：12=5+5+2
 *
 *  示例 2：
 *      输入：c[0]=5, k=7
 *      输出：-1
 *      说明：只用面值 5 的硬币无法凑出总金额 7
 * </pre>
 */
interface CoinChangeProblem {

    int coinChange(int[] coins, int amount);

}