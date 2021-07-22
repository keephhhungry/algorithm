package y2021.m07.d22;

/**
 * @author ： cxyxh
 * @date : 2021/7/22 23:05
 * @describetion :leetcode编号242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * <p>
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {

    public static void main(String[] args) {
        boolean ans = isAnagram("anagram", "nagaram");
        System.out.println(ans);
    }


    /**
     * 由于只出现26个字母，所以通过维护一个数组，s字符往对应的位置上+1，t字符往对应的位置上-1
     * 最后遍历数组是否都为0即可
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
            table[t.charAt(i) - 'a']--;
        }
        for (int i : table) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
