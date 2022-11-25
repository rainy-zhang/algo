package leetcode.easy;

import java.util.Arrays;

/**
 * <p>
 * 移动零
 * </p>
 * leetcode: https://leetcode.cn/problems/move-zeroes/
 * @author zhangyu
 */
public class MoveZeros {

    public static void main(String[] args) {
        moveZeros1();
        moveZeros2();
        moveZeros3();
    }
    
    private static void moveZeros1() {
        int[] nums = {1,0,0,3,12};
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
        int[] nums = {1,0,0,3,12};
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
        int[] nums = {1,0,0,3,12};
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
