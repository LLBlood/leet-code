package cn.liulin.leetcode.fixedwindows.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/17 16:40
 */
public class Class_1_FindSubstring30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int step = words[0].length();
        int sum = words.length * step;
        if (s.length() < sum) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < step; i++) {
            Map<String, Integer> tempMap = new HashMap<>(map);
            int count = 0;
            int tempIndex = i;
            while (tempIndex + step <= s.length()) {
                if (count == words.length) {
                    String diSubString = s.substring(tempIndex - step * count, tempIndex - step * (count - 1));
                    tempMap.put(diSubString, tempMap.getOrDefault(diSubString, 0) + 1);
                    count--;
                }
                // 0,3, 3,6, 6,9, 9,12
                String subString = s.substring(tempIndex, tempIndex + step);
                tempMap.put(subString, tempMap.getOrDefault(subString, 0) - 1);
                count++;
                tempIndex = tempIndex + step;
                if (count == words.length) {
                    boolean isTrue = true;
                    for (Map.Entry<String, Integer> stringIntegerEntry : tempMap.entrySet()) {
                        if (stringIntegerEntry.getValue() != 0) {
                            isTrue = false;
                            break;
                        }
                    }
                    if (isTrue) {
                        result.add(tempIndex - step * count);
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        new Class_1_FindSubstring30().findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
    }
}
