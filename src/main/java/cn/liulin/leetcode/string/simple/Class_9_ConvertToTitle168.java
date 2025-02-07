package cn.liulin.leetcode.string.simple;

/**
 * 168. Excel 表列名称
 *
 * @author liulin
 * @date 2025-02-07 15:36:14
 */
public class Class_9_ConvertToTitle168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int num = 26;
        int mod;
        int value = columnNumber;
        while (value > num) {
            mod = value % num;
            value = value / num;
            if (mod == 0) {
                mod += 26;
                value -= 1;
            }
            sb.append((char)('A' - 1 + mod));
        }
        if (value > 0) {
            sb.append((char)('A' - 1 + value));
        }
        return sb.reverse().toString();
    }

    /**
     * 将给定的列号转换为Excel表格中的列标题
     * 此方法遵循Excel命名规则，其中列标题由字母组成，从A开始递增（A, B, ..., Z, AA, AB, ...）
     *
     * @param columnNumber Excel表格中的列号，这是一个正整数
     * @return 对应的Excel列标题字符串
     */
    public String convertToTitle2(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // 减一以适应从0开始的索引，因为Excel的列号是从1开始计数的，而字母序列被视为从0开始（A=0, B=1, ..., Z=25）
            columnNumber--;
            // 计算当前列号对应的字母，并将其添加到字符串构建器中
            // 这里使用模运算找到当前列号在字母表中的位置
            sb.append((char)('A' + columnNumber % 26));
            // 更新列号为下一位字母的索引，通过整除26进位到下一字母序列
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Class_9_ConvertToTitle168().convertToTitle(52);
        System.out.println(s);
    }
}
