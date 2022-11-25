package leetcode.easy;

/**
 * <p>
 * 爬楼梯
 * </p>
 * leetcode: https://leetcode.cn/problems/climbing-stairs/
 * @author zhangyu
 */
public class ClimbStairs {

    public static void main(String[] args) {
        climbStairs1(45);
        System.out.println(climbStairs2(45));
    }

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
     */
    private static int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
    
}
