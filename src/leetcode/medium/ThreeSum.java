package leetcode.medium;

import java.util.*;

/**
 * <p>
 * 15. 三数之和
 * <p>
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * <p>
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * <p>
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/3sum/
 *
 * @author zhangyu
 */
public class ThreeSum {

    public static void main(String[] args) {
        threeSum();
        threeSum1();
        threeSum2();
    }

    /**
     * 三指针:
     * 先排序
     * 每次枚举出当前元素下标i，和后续元素中 “最左边的元素下标” 以及 “最右边的元素下标” 相加，判断是否等于 0
     * 如果 相加结果 > 0 说明本次枚举的三个元素大了，则“最右边元素下标”往左移动（right--）
     * 如果 相加结果 < 0 说明本次枚举的三个元素小了，则“最左边元素下标”往右移动（left++）
     * 如果 相加结果 = 0 则记录这三个元素，同时“最左边元素下标”往右移动(left++)和“最右边元素下标”往左移动(right--)，避免元素被重复计算
     */
    private static void threeSum() {
        List<List<Integer>> lists = new ArrayList<>();
        int[] nums = {-2, 0, 1, 1, 2};
//        int[] nums = {-2,0,0,2,2};

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 因为已经排序过了，所以如果当前的元素大于0，后续的元素肯定也都是大于0的，直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            // 对i去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int s = nums[i] + nums[left] + nums[right];
                if (s > 0) {
                    right--;
                } else if (s < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                }
            }

        }
        System.out.println(lists);

    }

    /**
     * 哈希表 + 两层循环
     */
    private static void threeSum1() {
        List<List<Integer>> lists = new ArrayList<>();
        int[] nums = {-1, 0, 1, 2, -1, -4};

        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            temp.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int target = -(nums[i] + nums[j]);
                if (temp.containsKey(target) && temp.get(target) > j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[temp.get(target)]);
                    lists.add(list);
                }
            }
        }


        System.out.println(lists);
    }

    /**
     * 三层嵌套循环
     */
    private static void threeSum2() {
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-4, -1, -1, 0, 1, 2};

        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 1; j++) {

                if (j > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int k = j + 1; k < nums.length; k++) {

                    if (k > 2 && k + 1 < nums.length && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);

                    }
                }
            }
        }

        System.out.println(lists);
    }

}
