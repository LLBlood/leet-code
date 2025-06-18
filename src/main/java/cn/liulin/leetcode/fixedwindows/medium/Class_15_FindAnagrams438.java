package cn.liulin.leetcode.fixedwindows.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * @author liulin
 * @version 1.0
 * @date 2025/6/17 16:09
 */
public class Class_15_FindAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] arr = new int[26];
        for (char c : p.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            arr[s.charAt(i) - 'a']--;
        }
        boolean isTrue = true;
        for (int i : arr) {
            if (i != 0) {
                isTrue = false;
                break;
            }
        }
        if (isTrue) {
            result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            arr[s.charAt(i - p.length()) - 'a']++;
            arr[s.charAt(i) - 'a']--;
            isTrue = true;
            for (int j : arr) {
                if (j != 0) {
                    isTrue = false;
                    break;
                }
            }
            if (isTrue) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
}
