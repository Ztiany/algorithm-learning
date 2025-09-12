package algorithm.geekdp;

/**
 * 斐波那契数列问题及其多种解题方案对比。
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        int n = 50;
        test(n, new IterativeFibonacci());
        test(n, new RecursiveFibonacci());
        test(n, new RecursiveWithMemoizationFibonacci());
    }

    private static void test(int n, FibonacciProblem fibonacciProblem) {
        System.out.println("Testing " + fibonacciProblem.getClass().getSimpleName());
        long startTime = System.currentTimeMillis();
        System.out.println("Fibonacci of " + n + " is: " + fibonacciProblem.calculate(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }

    /**
     * 斐波那契数列问题：f(n) = f(n-1) + f(n-2), f(0)=0, f(1)=1。
     */
    interface FibonacciProblem {
        long calculate(int n);
    }

    /**
     * 解题方案：迭代。
     */
    static class IterativeFibonacci implements FibonacciProblem {

        @Override
        public long calculate(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }

            long a = 0; // f(0)
            long b = 1; // f(1)
            long fib = 0;

            for (int i = 2; i <= n; i++) {
                fib = a + b; // f(n) = f(n-1) + f(n-2)
                a = b;       // 更新 f(n-2)
                b = fib;     // 更新 f(n-1)
            }

            return fib;
        }
    }

    /**
     * 解题方案：递归。
     */
    static class RecursiveFibonacci implements FibonacciProblem {

        @Override
        public long calculate(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return calculate(n - 1) + calculate(n - 2);
            }
        }
    }

    /**
     * 解题方案：递归 + 备忘录（Memoization）。
     */
    static class RecursiveWithMemoizationFibonacci implements FibonacciProblem {

        private long[] memo;

        @Override
        public long calculate(int n) {
            memo = new long[n + 1];
            return fib(n);
        }

        private long fib(int n) {
            if (n <= 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }

            if (memo[n] != 0) {
                return memo[n];
            }

            memo[n] = fib(n - 1) + fib(n - 2);
            return memo[n];
        }

    }

}
