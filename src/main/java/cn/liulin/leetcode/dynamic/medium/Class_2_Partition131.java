package cn.liulin.leetcode.dynamic.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * @author liulin
 * @date 2025-02-20 15:25:25
 */
public class Class_2_Partition131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }
        for (int i = 1; i <= s.length(); i++) {
            String substring = s.substring(0, i);
            int start = 0;
            int end = substring.length() - 1;
            boolean isEquals = true;
            while (start < end) {
                if (substring.charAt(start) != substring.charAt(end)) {
                    isEquals = false;
                    break;
                }
                start++;
                end--;
            }
            if (isEquals) {
                if (i != s.length()) {
                    List<List<String>> partition = partition(s.substring(i));
                    for (List<String> strings : partition) {
                        strings.add(0, substring);
                        result.add(strings);
                    }
                } else {
                    List<String> strings = new ArrayList<>();
                    strings.add(substring);
                    result.add(strings);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> partition = new Class_2_Partition131().partition("bb");
        System.out.println(partition);
    }

    public List<List<String>> partition2(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<String>();
        boolean[][] f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }
        dfs(s, 0, f, result, ans);
        return result;
    }

    private void dfs(String s, int i, boolean[][] f, List<List<String>> result, List<String> ans) {
        if (i == s.length()) {
            result.add(new ArrayList<>(ans));
        }
        for (int j = i; j < s.length(); ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1, f, result, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
