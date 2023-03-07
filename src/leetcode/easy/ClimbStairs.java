package leetcode.easy;

/**
 * <p>
 * 70. 爬楼梯
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/climbing-stairs/
 *
 * @author zhangyu
 */
public class ClimbStairs {

    public static void main(String[] args) {
        climbStairs1(45);
        System.out.println(climbStairs2(45));

    }


    /**
     * 循环
     * f1: 第一级台阶的走法
     * f2: 第二级台阶的走法
     * f3: 想要上第三级台阶，可以从第一级台阶走2步，也可以从第二级台阶走1步，所以第三级台阶的走法就等于 f1 + f2
     * 所以第n级台阶的走法就是，f(n-1) + f(n-2)
     */
    private static void climbStairs1(int n) {
        if (n <= 2) {
            return;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        System.out.println(f3);
    }

    /**
     * 递归
     * n=1: 1
     * n=2: 2
     * n=3: 想要上第三级台阶，可以从第一级台阶走2步，也可以从第二级台阶走1步，所以第三级台阶的走法就等于 f(1) + f(2)
     * 所以弟n级台阶的走法就是，f(n-1) + f(n-2)
     */
    private static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

}
