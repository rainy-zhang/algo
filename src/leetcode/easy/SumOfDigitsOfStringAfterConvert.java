package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 1945. 字符串转化后的各位数字之和
 * 给你一个由小写字母组成的字符串 s ，以及一个整数 k 。
 * 首先，用字母在字母表中的位置替换该字母，将 s 转化 为一个整数（也就是，'a' 用 1 替换，'b' 用 2 替换，... 'z' 用 26 替换）。接着，将整数 转换 为其 各位数字之和 。共重复 转换 操作 k 次 。
 * 例如，如果 s = "zbax" 且 k = 2 ，那么执行下述步骤后得到的结果是整数 8 ：
 * 转化："zbax" ➝ "(26)(2)(1)(24)" ➝ "262124" ➝ 262124
 * 转换 #1：262124 ➝ 2 + 6 + 2 + 1 + 2 + 4 ➝ 17
 * 转换 #2：17 ➝ 1 + 7 ➝ 8
 * 返回执行上述操作后得到的结果整数。
 *
 * 示例 1：
 * 输入：s = "iiii", k = 1
 * 输出：36
 * 解释：操作如下：
 * - 转化："iiii" ➝ "(9)(9)(9)(9)" ➝ "9999" ➝ 9999
 * - 转换 #1：9999 ➝ 9 + 9 + 9 + 9 ➝ 36
 * 因此，结果整数为 36 。
 * 
 * 示例 2：
 * 输入：s = "leetcode", k = 2
 * 输出：6
 * 解释：操作如下：
 * - 转化："leetcode" ➝ "(12)(5)(5)(20)(3)(15)(4)(5)" ➝ "12552031545" ➝ 12552031545
 * - 转换 #1：12552031545 ➝ 1 + 2 + 5 + 5 + 2 + 0 + 3 + 1 + 5 + 4 + 5 ➝ 33
 * - 转换 #2：33 ➝ 3 + 3 ➝ 6
 * 因此，结果整数为 6 。
 * 
 * </p>
 * leetcode: https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 * @author zhangyu
 */
public class SumOfDigitsOfStringAfterConvert {

    static String s = "iiii";
    static int k = 1;
    
    public static void main(String[] args) {
        System.out.println(getLucky());
    }
    
    private static int getLucky() {
        Map<String, Integer> words = new HashMap<>();
        words.put("a",1);
        words.put("b",2);
        words.put("c",3);
        words.put("i",9);

        String numberStr = "";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i) - 'a' + 1);
            numberStr += words.get(String.valueOf(s.charAt(i))) + "";
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            int temp = 0;
            for (int j = 0; j < numberStr.length(); j++) {
                temp += Integer.parseInt(String.valueOf(numberStr.charAt(j)));
            }
            res = temp;
        }

        return res;
    }
    
}
