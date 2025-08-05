package cn.liulin.leetcode.unfixedwindows.medium;

/**
 * 1248. 统计「优美子数组」
 *
 * @author liulin
 * @version 1.0
 * @date 2025/8/5 16:25
 */
public class Class_22_NumberOfSubarrays1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt1 = 0, cnt2 = 0, ans = 0;    // 两种奇数的个数 & 答案
        for(int left1 = 0, left2 = 0, right = 0; right < nums.length; right++){
            cnt1 += (nums[right] & 1);  // 统计大于等于k个奇数的窗口的奇数个数
            while(cnt1 >= k && left1 <= right) cnt1 -= (nums[left1++] & 1); //滑动
            cnt2 += (nums[right] & 1);  // 统计大于k个奇数的窗口的奇数个数
            while(cnt2 > k && left2 <= right) cnt2 -= (nums[left2++] & 1); //滑动
            ans += (left1-left2); // 两者相减即为恰好k个奇数的子数组个数
        }
        return ans;
    }

    public static void main(String[] args) {
        new Class_22_NumberOfSubarrays1248().numberOfSubarrays(new int[] {1,1,2,1,1}, 3);
    }
}
