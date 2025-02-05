package cn.liulin.leetcode.string.medium;

import java.util.Arrays;

/**
 * 6. Z 字形变换
 *
 * @author liulin
 * @date 2025-02-05 14:23:42
 */
public class Class_1_ZigzagConversion6 {
    /**
     * 当前方法相当于给字符串打标记，标记该字符串应该在哪一行
     *
     * @param s 字符串
     * @param numRows 实际行数
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-05 15:42:09
     */
    public String convert(String s, int numRows) {
        int[] sInt = new int[s.length()];
        if (numRows == 1) {
            Arrays.fill(sInt, 1);
        } else {
            int index = 1;
            int step = 1;
            sInt[0] = 1;
            for (int i = 1; i < s.length(); i++) {
                index += step;
                sInt[i] = index;
                if (index == numRows || index == 1) {
                    step *= -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 1; i <= numRows; i++) {
            for (int k = 0; k < charArray.length; k++) {
                if (sInt[k] == i) {
                    sb.append(charArray[k]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String ab = new Class_1_ZigzagConversion6().convert2("PAYPALISHIRING", 3);
        System.out.println(ab);
    }

    /**
     * 通过二维数组，重新组字符串
     *
     * @param s 字符串
     * @param numRows 行数
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-05 15:58:22
     */
    public String convert2(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        // 当前一个周期 r + r - 2;
        int t = 2 * numRows - 2;
        int c = (n + t - 1) / t * (numRows - 1);
        char[][] chars = new char[numRows][c];
        for (int i = 0, x = 0, y = 0; i < n; i++) {
            chars[x][y] = s.charAt(i);
            // 索引从0开始，在向下的周期内
            if (i % t < numRows - 1) {
                ++x; // 向下移动
            } else {
                --x; // 向上移动
                ++y; // 向右移动
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] aChar : chars) {
            for (char c1 : aChar) {
                if (c1 != 0) {
                    sb.append(c1);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 通过字符串数组，重新组字符串
     *
     * @param s 字符串
     * @param numRows 行数
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-05 15:58:22
     */
    public String convert3(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        // 当前一个周期 r + r - 2;
        int t = 2 * numRows - 2;
        int c = (n + t - 1) / t * (numRows - 1);
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        for (int i = 0, x = 0; i < n; i++) {
            rows[x].append(s.charAt(i));
            // 索引从0开始，在向下的周期内
            if (i % t < numRows - 1) {
                ++x; // 向下移动
            } else {
                --x; // 向上移动
            }
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder sbu : rows) {
            sb.append(sbu);
        }
        return sb.toString();
    }

    /**
     * 直接计算对应位置的字符
     *
     * @param s 字符串
     * @param numRows 行数
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-05 16:29:57
     */
    public String convert4(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        // 当前一个周期 r + r - 2;
        int t = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < n - i; j += t) {
                // 当前行第一个字符
                sb.append(s.charAt(j + i));
                // 如果不是第一行和最后一行，且存在数据
                if (i > 0 && i < numRows - 1 && j + t - i < n) {
                    sb.append(s.charAt(j + t - i));
                }
            }
        }
        return sb.toString();
    }

}
