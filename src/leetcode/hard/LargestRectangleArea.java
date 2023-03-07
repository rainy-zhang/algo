package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * 84. 柱状图中最大的矩形
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 * <p>
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/largest-rectangle-in-histogram
 *
 * @author zhangyu
 */
public class LargestRectangleArea {

    static int[] heights = {2, 2};

    public static void main(String[] args) {
        System.out.println(largestRectangleArea());
        System.out.println(largestRectangleArea2());
    }

    /**
     * 暴力破解，
     */
    private static int largestRectangleArea() {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                max = Math.max(max, (j - i + 1) * minHeight);
            }
        }
        return max;
    }

    /**
     * 单调栈，栈中的元素是从小到大排列的，如果当前元素比栈顶元素大，就压入栈中，如果比栈顶元素小，就说明右边界找到了，就把栈中所有小于当前元素的弹出去，并计算面积。
     * 要想找到第 i 位置最大面积是什么？
     * 是以i 为中心，向左找第一个小于 heights[i] 的位置 left_i；向右找第一个小于于 heights[i] 的位置 right_i，
     * 即最大面积为 heights[i] * (right_i - left_i -1)
     * 
     * [2,1,5,6,2,3], heights[4] * (right_i - left_i - 1) = 2 * (6 - 1 - 1) = 8 
     * 
     */
    private static int largestRectangleArea2() {
        int max = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[i] <= heights[deque.peek()]) {
                int height = heights[deque.pop()];
                int leftIndex = deque.isEmpty() ? -1 : deque.peek();
                int width = i - leftIndex - 1;
                max = Math.max(max, width * height);
            }
            deque.push(i);
        }
        
        while (!deque.isEmpty()) {
            int height = heights[deque.pop()];
            int leftIndex = -1;
            if (!deque.isEmpty()) {
                leftIndex = deque.peek();
            }
            max = Math.max(max, height * (heights.length - leftIndex - 1));
        }

        return max;
    }

}
