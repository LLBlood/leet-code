package cn.liulin.leetcode.string.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. 同构字符串
 *
 * @author liulin
 * @date 2025-02-08 10:38:28
 */
public class Class_11_IsIsomorphic205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c) {
                return false;
            }
            if (map2.containsKey(c) && map2.get(c) != c1) {
                return false;
            }
            map.put(c1, c);
            map2.put(c, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        new Class_11_IsIsomorphic205().isIsomorphic("foo", "bar");
    }
}
