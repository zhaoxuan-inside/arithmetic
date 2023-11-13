package leetcode;

import java.util.HashMap;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 */
public class topic_1160 {
    public int countCharacters(String[] words, String chars) {

        int result = 0;

        byte[] bytes = chars.getBytes();
        HashMap<Character, Integer> charsMap = new HashMap<>();

        for (byte aByte : bytes) {
            Integer integer = charsMap.get((char) aByte);
            if (integer == null){
                charsMap.put((char) aByte, 1);
            } else {
                Integer value = charsMap.get((char) aByte);
                charsMap.put((char) aByte, value + 1);
            }
        }

        for (String word : words) {
            boolean flag = true;
            byte[] wordBytes = word.getBytes();

            HashMap<Character, Integer> map = new HashMap<>();
            charsMap.putAll(map);

            for (byte wordByte : wordBytes) {
                Integer integer = map.get((char) wordByte);
                if (integer == null){
                    flag = false;
                    break;
                } else {
                    integer -= 1;
                    if (integer > 0){
                        map.put((char) wordByte, integer);
                    } else {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag){
                result += word.length();
            }

        }

        return result;

    }
}
