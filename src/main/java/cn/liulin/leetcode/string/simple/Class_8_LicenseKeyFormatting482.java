package cn.liulin.leetcode.string.simple;

/**
 * 482. 密钥格式化
 *
 * @author liulin
 * @date 2025-02-07 14:53:37
 */
public class Class_8_LicenseKeyFormatting482 {
    public String licenseKeyFormatting(String s, int k) {
        int tempCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int length = s.length() - 1; length >= 0; length--) {
            if (tempCount < k) {
                if (s.charAt(length) != '-') {
                    sb.append(Character.toUpperCase(s.charAt(length)));
                    tempCount++;
                }
            } else {
                if (s.charAt(length) != '-') {
                    tempCount = 1;
                    sb.append('-');
                    sb.append(Character.toUpperCase(s.charAt(length)));
                }
            }
        }
        return sb.reverse().toString();
    }

    /**
     * 用模运算减少判断条件和赋值问题
     *
     * @param s 源字符串
     * @param k 长度
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-07 15:08:55
     */
    public String licenseKeyFormatting2(String s, int k) {
        int tempCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int length = s.length() - 1; length >= 0; length--) {
            if (s.charAt(length) != '-') {
                sb.append(Character.toUpperCase(s.charAt(length)));
                tempCount++;
                if (tempCount % k == 0) {
                    sb.append('-');
                }
            }
        }
        if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '-') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
