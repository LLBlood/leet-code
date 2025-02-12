package cn.liulin.leetcode.string.medium;

/**
 * @author liulin
 * @date 2025-02-12 15:01:40
 */
public class Class_6_CountAndSay38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        return getString(countAndSay(n - 1));
    }

    public String getString(String s) {
        char c = s.charAt(0);
        int sum = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                sum++;
            } else {
                sb.append(sum).append(c);
                c = s.charAt(i);
                sum = 1;
            }
        }
        if (sum > 0) {
            sb.append(sum).append(c);
        }
        return sb.toString();
    }

    public String countAndSay2(int n) {
        String str = "1";
        for (int i = 2; i <= n; ++i) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;

            while (pos < str.length()) {
                while (pos < str.length() && str.charAt(pos) == str.charAt(start)) {
                    pos++;
                }
                sb.append((pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }

        return str;
    }
}
