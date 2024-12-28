package interview;

/**
 * 在字符串中找出连续最长的数字串，现有一个字符串 str，输出字符串 str 中的最长的数字子串。
 */
public class LongestNumInString {

    public static void main(String[] args) {
        new LongestNumInString().run("11111111111111111111111111111119999999999abcd12345ed125s111111111111111111111111111111199999999999s123058789 111111111888888888888888888881111111111111111111111");
    }

    private void run(String str) {
        int left1 = 0, right1 = 0;
        int left2 = 0, right2 = 0;
        boolean linking = false;
        boolean usingFirst = true;
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= '0' && array[i] <= '9') {
                if (!linking) {
                    linking = true;
                    if (usingFirst) {
                        right1 = left1 = i;
                    } else {
                        right2 = left2 = i;
                    }
                } else {
                    if (usingFirst) {
                        right1 = i;
                    } else {
                        right2 = i;
                    }
                }
            } else {
                linking = false;
                usingFirst = right1 - left1 <= right2 - left2;
            }
        }
        System.out.println("left1 " + left1 + " right1 " + right1);
        System.out.println("left2 " + left2 + " right2 " + right2);
        if (right1 - left1 > right2 - left2) {
            System.out.println(str.substring(left1, right1 + 1));
        } else {
            System.out.println(str.substring(left2, right2 + 1));
        }
    }

}
