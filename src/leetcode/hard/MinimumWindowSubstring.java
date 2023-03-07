package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 76. 最小覆盖子串
 * </p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * <p>
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * leetcode: https://leetcode.cn/problems/minimum-window-substring/
 *
 * @author zhangyu
 */
public class MinimumWindowSubstring {

    static String s = "ADOBECODEBANC";
    static String t = "ABC";

    public static void main(String[] args) {
        System.out.println(minWindow());
    }

    /**
     * 如果窗口中不包含t，right++
     * 如果窗口中包含t，left++
     */
    private static String minWindow() {
        String res = "";
        if (s.length() < t.length()) {
            return res;
        }
        // 用来保存目标字符串中所有字符
        Map<String, Integer> map1 = new HashMap<>();
        // 用来保存窗口中包含的字符
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            String key = String.valueOf(t.charAt(i));
            int value = 1;
            if (map1.containsKey(key)) {
                value = map1.get(key) + 1;
            }
            map1.put(key, value);
        }

        int left = 0;   // 窗口左边界
        int right = 1;  // 窗口右边界
        
        map2.put(s.substring(left, right), 1);

        while (right <= s.length()) {
            String subStr = s.substring(left, right);

            boolean isContains = true;
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() > map2.getOrDefault(key, 0)) {
                    isContains = false;
                    break;
                }
            }

            if (isContains) {   // 如果当前窗口包含t，right++
                if (res.equals("") || subStr.length() < res.length()) {
                    res = subStr;
                }
                
                // 左窗口向右移动，需要窗口中最后一个元素移除掉
                left++;
                String key = subStr.substring(0,1);
                map2.put(key, map2.get(key) - 1);
                
            } else {    // 如果当前窗口不包含t，right++
                right++;
                
                // 右窗口向右移动，需要将新的元素添加进窗口
                if (right <= s.length()) {
                    String key = s.substring(left, right).substring(right - left - 1);
                    int value = 1;
                    if (map2.containsKey(key)) {
                        value = map2.get(key) + 1;
                    }
                    map2.put(key, value);
                }
                
            }

        }
        return res;
    }

}
