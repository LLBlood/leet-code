package cn.liulin.leetcode.string.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 696. 计数二进制子串
 *
 * @author liulin
 * @date 2025-02-12 13:55:45
 */
public class Class_16_CountBinarySubstrings696 {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int sum = 0;
            boolean change = false;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == '0') {
                    sum += -1;
                } else {
                    sum += 1;
                }
                if (sum == 0) {
                    count++;
                    break;
                }
                if (j - i - 1 >= 0) {
                    if (s.charAt(j - 1) != s.charAt(j)) {
                        if (change) {
                            break;
                        }
                        change = true;
                    }
                }
            }
        }
        return count;
    }

    public int countBinarySubstrings2(String s) {
        List<Integer> countArr = new ArrayList<>();
        int ptr = 0;
        int n = s.length();
        while (ptr < n) {
            int count = 0;
            char c = s.charAt(ptr);
            while (ptr < n && s.charAt(ptr) == c) {
                count++;
                ptr++;
            }
            countArr.add(count);
        }
        int ans = 0;
        for (int i = 1; i < countArr.size(); i++) {
            ans += Math.min(countArr.get(i), countArr.get(i - 1));
        }
        return ans;
    }


    public int countBinarySubstrings3(String s) {
        int last = 0;
        int ptr = 0;
        int n = s.length();
        int ans = 0;
        while (ptr < n) {
            int count = 0;
            char c = s.charAt(ptr);
            while (ptr < n && s.charAt(ptr) == c) {
                count++;
                ptr++;
            }
            ans += Math.min(last, count);
            last = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_16_CountBinarySubstrings696().countBinarySubstrings("00110011");
    }
}
