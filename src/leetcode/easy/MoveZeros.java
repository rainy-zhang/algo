package leetcode.easy;

import java.util.Arrays;

/**
 * <p>
 * 283. 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/move-zeroes/
 *
 * @author zhangyu
 */
public class MoveZeros {

    static int[] nums = {1, 0, 0, 3, 12};

    public static void main(String[] args) {
        moveZeros1();
        moveZeros2();
        moveZeros3();
    }

    private static void moveZeros1() {
        int j = 0;  // 用来记录非0元素需要移动的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) { // 当前元素不为零，需要将其移动到前面去，并将当前位置的元素设置为0
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros2() {
        int j = 0;  // 用来记录非0元素需要移动的位置
        for (int i = 0; i < nums.length; i++) {
            // 如果当前元素不为零，需要将其移动到前面去
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        // 将j后面的元素全部设置为0
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros3() {
        int snowBallSize = 0;   // 用来记录零元素的数量
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {  // 如果当前元素不等于0，就把当前元素移动到前面，再把当前元素设置为零
                int temp = nums[i];
                nums[i] = 0;
                // 当前下标 - 零元素的数量 = 非零元素需要移动到的位置 
                nums[i - snowBallSize] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
