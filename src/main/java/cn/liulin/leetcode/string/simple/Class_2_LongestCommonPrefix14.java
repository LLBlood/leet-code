package cn.liulin.leetcode.string.simple;

/**
 * 14. 最长公共前缀
 *
 * @author liulin
 * @date 2025-01-22 14:49
 **/
public class Class_2_LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        int index = 0;
        while (true) {
            char temp = 0;
            for (String str : strs) {
                if (str.length() > index) {
                    if (temp == 0) {
                        temp = str.charAt(index);
                    } else if (temp != str.charAt(index)) {
                        return prefix.toString();
                    }
                } else {
                    return prefix.toString();
                }
            }
            prefix.append(temp);
            index++;
        }
    }

    /**
     * 纵向扫描
     * 不断对比每个字符串的同一个位置的字符，超出字符串范围或不相等，则返回相同部分字符串
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向扫描
     * 以第一个字符串为基准，不断与下一个字符串做前缀对比
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    /**
     * 分冶法
     */
    public String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            // 适用于 start 到 end（包括 end）的范围。
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs, start, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int minLength = Math.min(lcpLeft.length(), lcpRight.length());
        for (int i = 0; i < minLength; i++) {
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)) {
                return lcpLeft.substring(0, i);
            }
        }
        return lcpLeft.substring(0, minLength);
    }

    /**
     * 二分查找
     * 找到最小的字符串，二分获取中间节点到开始的前缀，对比所有字符串，如果相同，则说明公共前缀更大，重新二分获取中间节点，
     */
    public String longestCommonPrefix5(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0, high = minLength;
        while (low < high) {
            // 适用于 low 到 high - 1（不包括 high）的范围。
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
