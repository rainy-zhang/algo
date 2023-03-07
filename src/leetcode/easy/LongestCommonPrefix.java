package leetcode.easy;

/**
 * <p>
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * <p>
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/longest-common-prefix/
 *
 * @author zhangyu
 */
public class LongestCommonPrefix {

    static String[] strs = {"flower", "flow", "flight"};

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix());
    }

    /**
     * 横向扫描，枚举第一个单词中的每个字符，与其它单词的字符比较
     */
    private static String longestCommonPrefix() {
        String prefix = "";
        String str = strs[0];
        int n = 0;
        while (n < str.length()) {
            char c1 = str.charAt(n);
            for (int i = 1; i < strs.length; i++) {
                String str2 = strs[i];
                if (str2.length() <= n) {
                    return prefix;
                }
                char c2 = str2.charAt(n);
                if (c1 != c2) {
                    return prefix;
                }
            }
            prefix += c1;
            n++;
        }
        return prefix;
    }

}
