package interview;

/**
 * URL化
 *
 * 编写一种方法，将字符串中的空格全部替换为%20。
 *
 * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
 * （注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 */
public class interview_01_03 {
    public static String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i < chars.length){
                char ch = chars[i];
                if (ch == ' '){
                    result.append('%').append('2').append('0');
                } else {
                    result.append(ch);
                }
            } else {
                result.append('%').append('2').append('0');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("               ", 5));
    }
}