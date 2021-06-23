package y2021.m06.d18;

import java.util.*;

/**
 * @author ： cxyxh
 * @date : 2021/6/18 0:17
 * @describetion :leetcode编号20-有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * 1 <= s.length <= 10^4
 * s仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "()[]{}";
        boolean result = method1(s);
        System.out.println("结果为:[" + result + "]");
    }

    /**
     * 使用堆的特性来解决
     * 时间复杂度：O(n)，其中 n 是字符串 s 的长度。
     * 空间复杂度：O(n+6) 也就是O(n)。栈中的字符数量为 O(n)，而哈希表使用的空间为 O(6)，相加即可得到总空间复杂度。
     *
     * @param str 判断字符串
     * @return 返回结果
     */
    public static boolean method1(String str) {
        if (str.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 如果该字符是三类右括号其中的一种
            if (map.containsKey(c)) {
                // 如果stack为空 ， 或者最上面的元素不匹配，那么返回false
                if (stack.isEmpty() == true || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
                // 如果是左括号，那么直接添加
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
