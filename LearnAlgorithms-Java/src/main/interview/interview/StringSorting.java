package interview;

import java.util.Arrays;

/**
 * 输入一个字符串，长度小于等于 200，输出按字符顺序升序排序后的字符串。
 * 比如输入 bacd，输出 abcd。
 */
public class StringSorting {

    public static void main(String[] args) {
        new StringSorting().run("bacddalzdaerds");
    }

    private void run(String origin) {
        way1(origin);
        way2(origin);
    }

    private void way2(String origin) {
        char[] charArray = origin.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < charArray.length - i - 1; j++) {
                if (charArray[j] > charArray[j + 1]) {
                    char temp = charArray[j];
                    charArray[j] = charArray[j + 1];
                    charArray[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        System.out.println("result2: " + new String(charArray));
    }


    private static void way1(String origin) {
        char[] charArray = origin.toCharArray();
        Arrays.sort(charArray);
        System.out.println("result1: " + new String(charArray));
    }

}
