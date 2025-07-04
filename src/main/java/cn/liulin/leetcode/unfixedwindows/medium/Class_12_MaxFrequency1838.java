package cn.liulin.leetcode.unfixedwindows.medium;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * 1838. 最高频元素的频数
 *
 * @author liulin
 * @version 1.0
 * @date 2025/7/1 16:43
 */
public class Class_12_MaxFrequency1838 {
    public int maxFrequency(int[] nums, int k) {
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int left = 0;
        int ans = 0;
        long cost = 0;
        for (int right = 1; right < nums.length; right++) {
            cost += ((long) (nums[right] - nums[right - 1])) * (right - left);
            while (cost > k) {
                cost -= nums[right] - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Administrator\\Desktop\\1.txt"));
        StringBuilder s = new StringBuilder();
        while (bufferedReader.ready()) {
            s.append(bufferedReader.readLine());
        }
        String[] split = s.toString().split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        new Class_12_MaxFrequency1838().maxFrequency(ints, 1);
    }
}
