package cn.liulin.leetcode.string.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author liulin
 * @date 2025-02-17 10:17:19
 */
public class Class_9_RestoreIpAddresses93 {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 1 + 3; j++) {
                for (int k = j + 1; k < j + 1 + 3; k++) {
                    StringBuilder sb = new StringBuilder();
                    String first = s.substring(0, i + 1);
                    if (first.length() > 1 && (first.charAt(0) == '0' || Integer.parseInt(first) > 255)) {
                        continue;
                    }
                    sb.append(first).append(".");
                    if (j < s.length()) {
                        String second = s.substring(i + 1, j + 1);
                        if (second.length() > 1 && (second.charAt(0) == '0' || Integer.parseInt(second) > 255)) {
                            continue;
                        }
                        sb.append(second).append(".");
                    } else {
                        continue;
                    }
                    if (k < s.length()) {
                        String third = s.substring(j + 1, k + 1);
                        if (third.length() > 1 && (third.charAt(0) == '0' || Integer.parseInt(third) > 255)) {
                            continue;
                        }
                        sb.append(third).append(".");
                    } else {
                        continue;
                    }
                    if (k + 1 < s.length()) {
                        String fourth = s.substring(k + 1);
                        if (fourth.length() > 1 && (fourth.charAt(0) == '0' || Integer.parseInt(fourth) > 255)) {
                            continue;
                        }
                        sb.append(fourth);
                    } else {
                        continue;
                    }
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }

    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];
    public List<String> restoreIpAddresses2(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        if (segStart == s.length()) {
            return;
        }

        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
            return;
        }

        int addr = 0;
        for (int i = segStart; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }

    private void dfs2(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs2(s, segId + 1, segStart + 1);
            return;
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs2(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> strings = new Class_9_RestoreIpAddresses93().restoreIpAddresses2("25525511135");
        System.out.println(strings);
    }
}
