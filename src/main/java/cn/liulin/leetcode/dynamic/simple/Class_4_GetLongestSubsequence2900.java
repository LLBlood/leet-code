package cn.liulin.leetcode.dynamic.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. 最长相邻不相等子序列 I
 *
 * @author liulin
 * @date 2025-02-20 15:06:58
 */
public class Class_4_GetLongestSubsequence2900 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int preIndex = 0;
        result.add(words[preIndex]);
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] != groups[preIndex]) {
                preIndex = i;
                result.add(words[preIndex]);
            }
        }
        return result;
    }
}
