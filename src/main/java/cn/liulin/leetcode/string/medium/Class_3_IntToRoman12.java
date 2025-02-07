package cn.liulin.leetcode.string.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. 整数转罗马数字
 *
 * @author liulin
 * @date 2025-02-07 16:19:31
 */
public class Class_3_IntToRoman12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> countMap = new HashMap<>();
        while (num != 0) {
            if (num >= 1000 && countMap.getOrDefault(1000, 0) < 3) {
                sb.append(map.get(1000));
                countMap.put(1000, countMap.getOrDefault(1000, 0) + 1);
                num -= 1000;
            } else if (num >= 900 && countMap.getOrDefault(900, 0) < 4) {
                sb.append(map.get(900));
                countMap.put(900, countMap.getOrDefault(900, 0) + 1);
                num -= 900;
            } else if (num >= 500 && countMap.getOrDefault(500, 0) < 1) {
                sb.append(map.get(500));
                countMap.put(500, countMap.getOrDefault(500, 0) + 1);
                num -= 500;
            } else if (num >= 400 && countMap.getOrDefault(400, 0) < 4) {
                sb.append(map.get(400));
                countMap.put(400, countMap.getOrDefault(400, 0) + 1);
                num -= 400;
            } else if (num >= 100 && countMap.getOrDefault(100, 0) < 3) {
                sb.append(map.get(100));
                countMap.put(100, countMap.getOrDefault(100, 0) + 1);
                num -= 100;
            } else if (num >= 90 && countMap.getOrDefault(90, 0) < 4) {
                sb.append(map.get(90));
                countMap.put(90, countMap.getOrDefault(90, 0) + 1);
                num -= 90;
            } else if (num >= 50 && countMap.getOrDefault(50, 0) < 1) {
                sb.append(map.get(50));
                countMap.put(50, countMap.getOrDefault(50, 0) + 1);
                num -= 50;
            } else if (num >= 40 && countMap.getOrDefault(40, 0) < 4) {
                sb.append(map.get(40));
                countMap.put(40, countMap.getOrDefault(40, 0) + 1);
                num -= 40;
            } else if (num >= 10 && countMap.getOrDefault(10, 0) < 3) {
                sb.append(map.get(10));
                countMap.put(10, countMap.getOrDefault(10, 0) + 1);
                num -= 10;
            } else if (num >= 9 && countMap.getOrDefault(9, 0) < 4) {
                sb.append(map.get(9));
                countMap.put(9, countMap.getOrDefault(9, 0) + 1);
                num -= 9;
            } else if (num >= 5 && countMap.getOrDefault(5, 0) < 1) {
                sb.append(map.get(5));
                countMap.put(5, countMap.getOrDefault(5, 0) + 1);
                num -= 5;
            } else if (num >= 4 && countMap.getOrDefault(4, 0) < 4) {
                sb.append(map.get(4));
                countMap.put(4, countMap.getOrDefault(4, 0) + 1);
                num -= 4;
            } else {
                sb.append(map.get(1));
                num -= 1;
            }
        }
        return sb.toString();
    }

    /**
     * 不断循环，减去大的数即可
     *
     * @param num 数值
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-07 16:58:01
     */
    public String intToRoman2(int num) {
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                num -= value[i];
                sb.append(symbol[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return sb.toString();
    }

    /**
     * 硬编码
     *
     * @param num 数字
     * @return java.lang.String
     * @author liulin
     * @date 2025-02-07 17:04:25
     */
    public String intToRoman3(int num) {
        String[] thousand = {"","M","MM","MMM"};
        String[] hundred = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ten = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] one = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return thousand[num / 1000] + hundred[num % 1000 / 100] + ten[num % 100 / 10] + one[num % 10];
    }

    public static void main(String[] args) {
        String s = new Class_3_IntToRoman12().intToRoman2(3749);
        System.out.println(s);
    }
}
