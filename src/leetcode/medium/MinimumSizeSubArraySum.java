package leetcode.medium;

/**
 * <p>
 * 209. 长度最小的子数组
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * <p>
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/minimum-size-subarray-sum/
 *
 * @author zhangyu
 */
public class MinimumSizeSubArraySum {

    static int[] nums = {10,2,3};
    static int target = 6;

    public static void main(String[] args) {
        System.out.println(minSubArrayLen());
    }

    /**
     * 双指针，
     */
    private static int minSubArrayLen() {
        int res = 0;
        int left = 0;
        int right = 0;
        int sum = nums[left];
        while (right < nums.length) {
            
            if (sum >= target) {
                if (res > right - left || res == 0) {
                    res = right - left + 1;
                }
                sum -= nums[left];
                left++;
            } else {
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }
        return res;
    }

}
