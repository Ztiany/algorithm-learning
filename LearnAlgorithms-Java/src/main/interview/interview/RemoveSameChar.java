package interview;

/**
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。
 * 例如：第一个字符串是 "They are students."，第二个字符串是 ”aeiou"。删除之后的第一个字符串变成 "Thy r stdnts."。
 */
public class RemoveSameChar {

    public static void main(String[] args) {
        new RemoveSameChar().run("They are students.", "aeiou");
    }

    private void run(String origin, String eraser) {
        for (int i = 0; i < eraser.length(); i++) {
            origin = origin.replace(String.valueOf(eraser.charAt(i)), "");
        }
        System.out.println(origin);
    }

}
