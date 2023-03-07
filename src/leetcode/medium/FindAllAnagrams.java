package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 438. 找到字符串中所有字母异位词
 * 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 
 * </p>
 * leetcode: https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * @author zhangyu
 */
public class FindAllAnagrams {

    static String s = "abab";
    static String p = "ab";
    
    public static void main(String[] args) {
        System.out.println(findAnagrams());
    }
    
    private static List<Integer> findAnagrams() {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }

        int left = 0;
        int right = p.length();

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char key = p.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        String subStr = s.substring(left, right);
        for (int i = 0; i < subStr.length(); i++) {
            char key = subStr.charAt(i);
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        while (right <= s.length()) {
            subStr = s.substring(left, right);

            boolean isAnagrams = true;

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                int value = entry.getValue();
                if (value != map2.getOrDefault(key, 0)) {
                    isAnagrams = false;
                }
            }

            if (isAnagrams) {
                res.add(left);
            }

            right++;
            if (right <= s.length()) {
                char key = s.charAt(right-1);
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }

            char key = subStr.charAt(0);
            map2.put(key, map2.get(key) - 1);
            left++;
        }

        return res;
    }
    
    
    
    
}
