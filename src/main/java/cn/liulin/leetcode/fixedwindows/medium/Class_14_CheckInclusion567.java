package cn.liulin.leetcode.fixedwindows.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 *
 * @author liulin
 * @version 1.0
 * @date 2025/4/21 9:48
 */
public class Class_14_CheckInclusion567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        if (checkSuccess(map)) {
            return true;
        }
        for (int i = length; i < s2.length(); i++) {
            char preC = s2.charAt(i - length);
            char afterC = s2.charAt(i);
            if (map.containsKey(preC)) {
                map.put(preC, map.get(preC) + 1);
            }
            if (map.containsKey(afterC)) {
                map.put(afterC, map.get(afterC) - 1);
            }
            if (checkSuccess(map)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int length = s1.length();
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s2.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    size++;
                }
                map.put(c, map.get(c) - 1);
            }
        }
        if (size == length) {
            return true;
        }
        for (int i = length; i < s2.length(); i++) {
            char preC = s2.charAt(i - length);
            char afterC = s2.charAt(i);
            if (map.containsKey(preC)) {
                map.put(preC, map.get(preC) + 1);
                if (map.get(preC) > 0) {
                    size--;
                }
            }
            if (map.containsKey(afterC)) {
                if (map.get(afterC) > 0) {
                    size++;
                }
                map.put(afterC, map.get(afterC) - 1);
            }
            if (size == length) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInclusion3(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        // 找到s1所有char对应的数量
        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }

        // 计算s1不同类别的char对应的数量
        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0){
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen){
            // 如果s2的right位置对应的字符在s1中存在，则s2的right位置对应的字符在数组中++
            if (pFreq[text[right] - 'a'] > 0 ) {
                winFreq[text[right] - 'a']++;
                // 如果s2的right位置对应的字符在s1中存在且相等，则winCount++
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']){
                    winCount++;
                }
            }
            right++;

            // 如果pCount和winCount相等，且right-left刚好是s1的长度，则返回true，否则定长窗口不断右移
            while (pCount == winCount){
                if (right - left == pLen){
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0 ) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']){
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }

    private boolean checkSuccess(Map<Character, Integer> map) {
        for (Integer value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
