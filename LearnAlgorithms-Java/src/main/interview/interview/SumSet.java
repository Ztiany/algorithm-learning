package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两个整数 n 和 m，从数列 1，2，3.......n 中随意取几个数，使其和等于 m，要求将其中所有的可能组合列出来。
 */
public class SumSet {

    private final List<List<Integer>> all = new ArrayList<>();

    public static void main(String[] args) {
        new SumSet().run(10, 10);
    }

    private void run(int n, int m) {
        all.clear();

        int max = max(1, n);
        System.out.println("max = " + max);
        if (max < m) {
            System.out.println("result = empty");
            return;
        }
        find(1, n, m, new ArrayList<>());
        for (List<Integer> list : all) {
            System.out.println("result = " + list);
        }
    }

    private static int max(int start, int end) {
        int n = end - start + 1; // elementSize
        return (n * ((n - 1) + 2 * start)) / 2;
    }

    private void find(int start, int end, int target, List<Integer> list) {
        if (target == 0) {
            all.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < end; i++) {
            if (i > target) {
                break;
            }
            list.add(i);
            find(i + 1, end, target - i, list);
            list.remove(list.size() - 1);
        }
    }

}
