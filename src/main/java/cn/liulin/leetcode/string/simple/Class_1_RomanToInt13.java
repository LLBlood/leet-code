package cn.liulin.leetcode.string.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 核心思想 当前位置的元素比下个位置的元素小，就减去当前值，否则加上当前值
 * @author liulin
 * @date 2025-01-22 14:29
 **/
public class Class_1_RomanToInt13 {
    private static final Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        int sum = 0;
        while (index < chars.length) {
            char first = chars[index];
            if (index + 1 < chars.length) {
                char second = chars[index + 1];
                if (map.get(first) < map.get(second)) {
                    sum = sum + map.get(second) - map.get(first);
                    index += 2;
                    continue;
                }
            }
            sum = sum + map.get(first);
            index += 1;
        }
        return sum;
    }

    public int romanToInt2(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int index = 0; index < chars.length; index++) {
            char first = chars[index];
            if (index + 1 < chars.length && map.get(first) < map.get(chars[index + 1])) {
                sum = sum - map.get(first);
                continue;
            }
            sum = sum + map.get(first);
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
