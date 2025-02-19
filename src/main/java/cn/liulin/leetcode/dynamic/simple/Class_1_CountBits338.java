package cn.liulin.leetcode.dynamic.simple;

/**
 * 338. 比特位计数
 *
 * @author liulin
 * @date 2025-02-19 09:45:55
 */
public class Class_1_CountBits338 {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        String pre = "0";
        ans[0] = 0;
        for (int i = 1; i <= n; i++) {
            char[] charArray = pre.toCharArray();
            int count = ans[i - 1];
            for (int j = charArray.length - 1; j >= 0; j--) {
                if (charArray[j] == '1') {
                    charArray[j] = '0';
                    count--;
                } else {
                    charArray[j] = '1';
                    count++;
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (charArray[0] == '0') {
                sb.append("1").append(charArray);
                count++;
            } else {
                sb.append(charArray);
            }
            pre = sb.toString();
            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Class_1_CountBits338().countBits(8);
    }

    /**
     * Brian Kernighan 算法
     *
     * @param n 参数n
     * @return int[]
     * @author liulin
     * @date 2025-02-19 10:35:56
     */
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }

    /**
     * 最高有效位
     * 当(i & (i - 1)) == 0时，i就是2的整数次幂，最高有效位就是i
     * 令z = x - y, x是当前值，y就是最高有效位值，此时y的1的数量就是1，则 bit[x] = bit[z] + 1;
     *
     * @param n 参数n
     * @return int[]
     * @author liulin
     * @date 2025-02-19 10:38:22
     */
    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        int hit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                hit = i;
            }
            bits[i] = bits[i - hit] + 1;
        }
        return bits;
    }

    /**
     * 最低有效位
     * x 和 x/2 的值相比较，就是 x 右移一位 ，当x是偶数时，最后一位为0，右移不影响1的值，当x是奇数时，需要弥补1
     * 则 bit[x] = bit[x / 2] ;  bit[x] = bit[x / 2] + 1 ;
     * 综合就是bit[x] = bit[x >> 1] + x % 2;  bit[x] = bit[x >> 1] + (x & 1);
     *
     * @param n 参数n
     * @return int[]
     * @author liulin
     * @date 2025-02-19 10:38:22
     */
    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    /**
     * 最低设置位
     *
     * @param n 参数n
     * @return int[]
     * @author liulin
     * @date 2025-02-19 10:38:22
     */
    public int[] countBits5(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[(i & (i - 1))] + 1;
        }
        return bits;
    }
}
