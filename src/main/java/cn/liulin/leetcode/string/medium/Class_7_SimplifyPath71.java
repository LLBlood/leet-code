package cn.liulin.leetcode.string.medium;

import java.util.*;

/**
 * 71. 简化路径
 *
 * @author liulin
 * @date 2025-02-13 13:06:32
 */
public class Class_7_SimplifyPath71 {
    public String simplifyPath(String path) {
       List<String> list = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
        for (char c : path.toCharArray()) {
            if (c == '/') {
                if ("..".contentEquals(sb)) {
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                } else if (sb.length() != 0 && !".".contentEquals(sb)) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() != 0) {
            if ("..".contentEquals(sb)) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!".".contentEquals(sb)) {
                list.add(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        if (!list.isEmpty()) {
            for (String s : list) {
                result.append("/").append(s);
            }
        } else {
            result.append("/");
        }
        return result.toString();
    }

    public String simplifyPath2(String path) {
        String[] split = path.split("/");
        // 可以作为队列，也可以作为栈
        Deque<String> deque = new ArrayDeque<>();
        for (String s : split) {
            if ("..".equals(s)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (!s.isEmpty() && !".".equals(s)) {
                deque.offerLast(s);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (deque.isEmpty()) {
            ans.append('/');
        } else {
            while (!deque.isEmpty()) {
                ans.append('/');
                ans.append(deque.pollFirst());
            }
        }
        return ans.toString();
    }

}
