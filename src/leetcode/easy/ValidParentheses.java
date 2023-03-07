package leetcode.easy;

import java.util.Stack;

/**
 * <p>
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 *
 * </p>
 * leetcode: https://leetcode.cn/problems/valid-parentheses/
 *
 * @author zhangyu
 */
public class ValidParentheses {

    static String str = "[]{";

    public static void main(String[] args) {
        System.out.println(isValid());;
        System.out.println(isValid2());;
    }

    /**
     * 遍历，如果碰到左括号就添加到栈中，如果碰到右括号就从栈中弹出一个左括号，并判断左右括号是否匹配，最后判断栈是否为空，为空则说明字符串有效
     */
    private static boolean isValid() {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                
                if (stack.isEmpty()) {
                    return false;
                }
                char character = stack.pop();
                
                if (c == '}' && character != '{') {
                    return false;
                } else if (c == ']' && character != '[') {
                    return false;
                } else if (c == ')' && character != '(') {
                    return false;
                }
                
            }
        }
        return stack.isEmpty();
    }

    /**
     * 通过replace函数实现
     */
    private static boolean isValid2() {
        while (str.contains("{}") || str.contains("[]") || str.contains("()")) {
            str = str.replace("{}", "").replace("[]", "").replace("()", "");
        }
        return "".equals(str);
    }
    
    
}
