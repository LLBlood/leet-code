package cn.liulin.leetcode.fixedwindows.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2653. 滑动子数组的美丽值
 *
 * @author liulin
 * @date 2025-02-28 17:35:21
 */
public class Class_11_GetSubarrayBeauty2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        int Base = 50;//计数排序
        int[] cnt = new int[Base * 2 + 1];
        //入窗口
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + Base]++;
        }
        for (int i = k - 1; i < nums.length; i++) {
            cnt[nums[i] + Base]++;
            //第x小
            int left = x;
            // 因为此处这个吊毛，要么为负数，大于等于0则直接为0
            for (int j = 0; j < Base; j++) {
                left -= cnt[j];
                if (left <= 0) {
                    res[i - k + 1] = j - Base;
                    break;
                }
            }
            cnt[nums[i - k + 1] + Base]--;//出窗口}
        }
        return res;
    }
}
