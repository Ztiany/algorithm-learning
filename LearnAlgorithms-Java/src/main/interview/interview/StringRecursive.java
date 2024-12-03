package interview;

/**
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * 比如：输入 s ="gwe" ，输出：["gwe", "gew", "weg", "wge", "egw", "ewg"]。
 */
public class StringRecursive {

    private static final String s = "abc";

    public static void main(String[] args) {
        permutation(s);
    }

    private static void permutation(String s) {
        doPermutation(s, "");
    }

    private static void doPermutation(String s, String prefix) {
        if (s.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < s.length(); i++) {
                String sub = String.valueOf(s.charAt(i));
                doPermutation(s.replace(sub, ""), prefix + sub);
            }
        }
    }

}