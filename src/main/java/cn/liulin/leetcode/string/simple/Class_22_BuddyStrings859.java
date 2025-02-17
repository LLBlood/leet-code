package cn.liulin.leetcode.string.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 859. 亲密字符串
 *
 * @author liulin
 * @date 2025-02-17 09:49:48
 */
public class Class_22_BuddyStrings859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.length() < 2) {
            return false;
        }
        if (s.equals(goal)) {
            // 判断s是否存在两个相等的字符
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    return true;
                }
                set.add(s.charAt(i));
            }
            return false;
        }
        // 判断s和goal是否只有两处不同
        int count = 0;
        int[] arr = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
                arr[count - 1] = i;
            }
        }
        return s.charAt(arr[0]) == goal.charAt(arr[1]) && s.charAt(arr[1]) == goal.charAt(arr[0]);
    }
}
