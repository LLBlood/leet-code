package cn.liulin.leetcode.string.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liulin
 * @date 2025-02-14 13:11:50
 */
public class Class_21_LargeGroupPositions830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        if (s.length() <= 2) {
            return list;
        }
        char[] charArray = s.toCharArray();
        int count = 1;
        int start = 0;
        char c = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            char c1 = charArray[i];
            if (c1 == c) {
                count++;
            } else {
                if (count >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(start);
                    temp.add(i - 1);
                    list.add(temp);
                }
                count = 1;
                start = i;
                c = c1;
            }
        }
        if (count >= 3) {
            List<Integer> temp = new ArrayList<>();
            temp.add(start);
            temp.add(charArray.length - 1);
            list.add(temp);
        }
        return list;
    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> list = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i - num + 1);
                    temp.add(i);
                    list.add(temp);
                }
                num = 1;
            } else {
                num++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        new Class_21_LargeGroupPositions830().largeGroupPositions("abcdddeeeeaabbbcd");
    }
}
