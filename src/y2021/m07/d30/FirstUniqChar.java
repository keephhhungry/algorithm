package y2021.m07.d30;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ： cxyxh
 * @date : 7/30/2021 11:30 PM
 * @describetion :387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        int ans = firstUniqChar("leetcode");
        System.out.println(ans);
    }

    /**
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int ans = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return ans;
    }
}
