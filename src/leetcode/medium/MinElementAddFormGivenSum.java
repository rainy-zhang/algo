package leetcode.medium;

/**
 * <p>
 * 1785. 构成特定和需要添加的最少元素
 * 
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 *
 * 示例 1：
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * 
 * 示例 2：
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 * 
 * </p>
 * leetcode: https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 *
 * @author zhangyu
 */
public class MinElementAddFormGivenSum {

    static int[] nums = {-2,-5,-3,0,-7,5,3,7,-1};
    static int limit = 7;
    static int goal = 897960632;
    
    public static void main(String[] args) {
        System.out.println(minElements());
    }

    private static int minElements() {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int target = goal - sum;

        if (Math.abs(target) <= limit) {
            return 1;
        }

        int count = 0;
        while (target != 0) {
            if (Math.abs(target) <= limit) {
                count++;
                break;
            }
            if (target > 0) {
                target -= limit;
            } else {
                target += limit;
            }
            count++;
        }
        return count;
    }
    
}
