package y2021.m08.d15;

/**
 * @author ： cxyxh
 * @date : 8/15/2021 11:31 PM
 * @describetion :389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * <p>
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * <p>
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDifference {

    public static void main(String[] args) {
        String s = "abc";
        String t = "cbae";
        char ans = findTheDifference(s, t);
        System.out.println(ans);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); ++i) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }


}
