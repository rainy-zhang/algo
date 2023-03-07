package leetcode.medium;

import java.util.Arrays;

/**
 * <p>
 * 189. 轮转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/rotate-array/
 *
 * @author zhangyu
 */
public class RotateArray {

    public static void main(String[] args) {
        rotateArray1();
    }

    private static void rotateArray1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int len = nums.length;
        int[] nums2 = new int[len];
        int k = 8;

        for (int i = 0; i < nums.length; i++) {
            nums2[(i + k) % len] = nums[i];
        }

        System.out.println(Arrays.toString(nums2));

    }

}
