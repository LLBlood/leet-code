package cn.liulin.leetcode.string.simple;

import java.util.*;

/**
 * 819. 最常见的单词
 *
 * @author liulin
 * @date 2025-02-13 11:38:09
 */
public class Class_19_MostCommonWord819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : banned) {
            map.put(s, -1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() != 0) {
                if (!map.containsKey(sb.toString()) || map.get(sb.toString()) != -1) {
                    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                }
                sb = new StringBuilder();
            }
        }

        if (sb.length() != 0) {
            if (!map.containsKey(sb.toString()) || map.get(sb.toString()) != -1) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }

        int value = Integer.MIN_VALUE;
        String result = "";
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            String key = stringIntegerEntry.getKey();
            Integer value1 = stringIntegerEntry.getValue();
            if (value1 > value) {
                result = key;
                value = value1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Class_19_MostCommonWord819().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"});
    }
}
