package y2021.m07.d17;

import java.util.HashMap;

/**
 * @author ： cxyxh
 * @date : 2021/7/17 10:13
 * @describetion :leetcode编号203. 移除链表元素
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 可以假设 s 和 t 长度相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsIsomorphic {

    public static void main(String[] args) {
        //boolean isomorphic = isIsomorphic("egg", "add");
        boolean isomorphic = isIsomorphic("foo", "bar");
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if ((map1.containsKey(a) && (map1.get(a) != b)) || (map2.containsKey(b) && (map2.get(b) != a))) {
                return false;
            } else {
                map1.put(a, b);
                map2.put(b, a);
            }
        }
        return true;
    }
}
