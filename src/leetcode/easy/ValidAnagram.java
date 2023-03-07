package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * </p>
 * <p>
 * leetcode: https://leetcode.cn/problems/valid-anagram/
 *
 * @author zhangyu
 */
public class ValidAnagram {

    static String s = "anagram";
    static String t = "nagaram";
    
    public static void main(String[] args) {
        System.out.println(isAnagram());
        System.out.println(isAnagram2());
    }

    /**
     * 哈希表 
     */
    private static boolean isAnagram() {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            if (!map.containsKey(key)) {
                return false;
            }
            int value = map.get(key) - 1;
            if (value > 0) {
                map.put(key, value);
            } else {
                map.remove(key);
            }
        }
        return map.isEmpty();
    }

    /**
     * 排序后，比较两个字符串是否相等
     */
    private static boolean isAnagram2() {
        if (s.length() != t.length()) {
            return false;
        }

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
}
