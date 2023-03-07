package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 1. 两数之和
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/two-sum/
 *
 * @author zhangyu
 */
public class TwoSum {

    public static void main(String[] args) {
        twoSum(9);
        twoSum2(9);
    }

    /**
     * 哈希表+一次循环
     *
     * @param target
     */
    private static void twoSum(int target) {
        int[] nums = {2, 7, 11, 15};
        int[] res = new int[2];
        Map<Integer, Integer> temp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (temp.containsKey(n)) {
                res[0] = i;
                res[1] = temp.get(n);
                break;
            }
        }
        System.out.println(Arrays.toString(res));
    }

    /**
     * 嵌套循环
     *
     * @param target
     */
    private static void twoSum2(int target) {
        int[] nums = {2, 7, 11, 15};
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        System.out.println(Arrays.toString(res));
    }

}
