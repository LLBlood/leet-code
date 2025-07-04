package cn.liulin.leetcode.unfixedwindows.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author liulin
 * @version 1.0
 * @date 2025/7/4 14:43
 */
public class Class_16_ShortestBeautifulSubstring2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            if (aChar == '1') {
                sum++;
            }
        }
        if (sum < k) {
            return "";
        }
        int left = 0;
        String result = s;
        StringBuilder sb = new StringBuilder();
        int cost = 0;
        for (int right = 0; right < chars.length; right++) {
            sb.append(chars[right]);
            cost += chars[right] - '0';
            while (cost - (chars[left] - '0') >= k) {
                cost -= chars[left] - '0';
                left++;
                sb.deleteCharAt(0);
            }
            if (cost >= k) {
                result = sb.length() < result.length() ? sb.toString() : sb.length() == result.length() ? sb.toString().compareTo(result) < 0 ? sb.toString() : result : result;
            }
        }
        return result;
    }
}
