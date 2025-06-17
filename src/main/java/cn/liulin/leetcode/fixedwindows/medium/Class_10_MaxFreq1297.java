package cn.liulin.leetcode.fixedwindows.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1297. 子串的最大出现次数
 *
 * @author liulin
 * @date 2025-02-28 17:03:03
 */
public class Class_10_MaxFreq1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - minSize; i++) {
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + maxSize; j++) {
                sb.append(s.charAt(j));
                set.add(s.charAt(j));
                if (j < i + minSize - 1) {
                    continue;
                }
                if (set.size() > maxLetters) {
                    break;
                }
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
                if (j + 1 >= n) {
                    break;
                }
            }
        }
        int maxValue = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        new Class_10_MaxFreq1297().maxFreq("aababcaab", 2, 3, 4);
    }

    public int maxFreq2(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i <= n - minSize; i++) {
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int j = i; j < i + minSize; j++) {
                sb.append(s.charAt(j));
                set.add(s.charAt(j));
            }
            if (set.size() <= maxLetters) {
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            }
        }
        int maxValue = 0;
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            Integer value = stringIntegerEntry.getValue();
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}
