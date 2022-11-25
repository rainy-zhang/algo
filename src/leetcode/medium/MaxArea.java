package leetcode.medium;

/**
 * <p>
 * 盛水最多的容器
 * </p>
 * leetcode: https://leetcode.cn/problems/container-with-most-water/
 *
 * @author zhangyu
 */
public class MaxArea {

    public static void main(String[] args) {
        maxArea1();
        maxArea2();
    }

    private static void maxArea1() {
        // 枚举：left和right, 通过left和right之间的距离 * left和right中数值比较小的柱子.
        // 可以理解为求矩形的面积（长 * 宽 = 面积）
        // (right - left) * low
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 1};
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int distance = j - i;   //
                int low = Math.min(nums[i], nums[j]);   // 取left和right中小的值

                if (distance * low > max) {
                    max = distance * low;
                }

            }
        }
        System.out.println(max);
    }

    private static void maxArea2() {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 1};
        
        // 如果外围的柱子长度比内部柱子高，那外围柱子围成的面积就一定更大
        // 枚举出数组中左边界和有边界，如果左边界大于右边界，则右边界向左移动，反之左边界向右移动
        int left = 0;
        int right = nums.length - 1;
        
        int max = 0;
        while (left != right) {
            int minHeight = Math.min(nums[left], nums[right]);
            max = Math.max((right - left) * minHeight, max);
            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(max);
    }

}

