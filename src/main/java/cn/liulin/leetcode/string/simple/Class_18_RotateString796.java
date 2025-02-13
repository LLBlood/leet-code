package cn.liulin.leetcode.string.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 796. 旋转字符串
 *
 * @author liulin
 * @date 2025-02-13 10:13:26
 */
public class Class_18_RotateString796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int count = 0;
        do {
            if (s.equals(goal)) {
                return true;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(0).append(s.charAt(0));
            s = sb.toString();
            count++;
        } while (count < s.length());
        return false;
    }

    public boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        char c = goal.charAt(0);
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                indexList.add(i);
            }
        }
        if (indexList.isEmpty()) {
            return false;
        }
        for (Integer i : indexList) {
            boolean isTrue = true;
            for (int j = 0; j < goal.length(); j++) {
                if (goal.charAt(j) == s.charAt(i % s.length())) {
                    i++;
                } else {
                    isTrue = false;
                }
            }
            if (isTrue) {
                return true;
            }
        }
        return false;
    }

    public boolean rotateString3(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String res = s + s;
        // 求接next数组
        int[] next = getNextArr(goal);
        int k = 0;
        for (int i = 0; i < res.length(); i++) {
            while (k > 0 && res.charAt(i) != goal.charAt(k)) {
                k = next[k - 1];
            }
            if (res.charAt(i) == goal.charAt(k)) {
                k++;
            }
            if (k == goal.length()) {
                return true;
            }
        }
        return false;
    }

    private int[] getNextArr(String str) {
        int[] arr = new int[str.length()];
        int k = 0;
        arr[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            while (k > 0 && str.charAt(i) != str.charAt(k)) {
                k = arr[k - 1];
            }
            if (str.charAt(i) == str.charAt(k)) {
                k++;
            }
            arr[i] = k;
        }
        return arr;
    }

    public static void main(String[] args) {
        boolean b = new Class_18_RotateString796().rotateString("abcde", "cdeab");
    }
}
