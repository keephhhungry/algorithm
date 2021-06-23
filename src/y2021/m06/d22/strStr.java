package y2021.m06.d22;

/**
 * @author ： cxyxh
 * @date : 2021/6/22 0:10
 * @describetion :leetcode编号28. 实现 strStr()
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * <p>
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * <p>
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * <p>
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class strStr {

    // TODO KMP算法需要了解
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int index = strStr(haystack, needle);
        System.out.println("开始的角标为:[" + index + "]");

    }

    /**
     * 暴力匹配
     * 时间复杂度：O(n×m)，其中 n 是字符串 haystack 的长度，m 是字符串needle 的长度。最坏情况下我们需要将字符串eedle 与字符串 haystack 的所有长度为 m 的子串均匹配一次。
     * 空间复杂度：O(1)  。我们只需要常数的空间保存若干变量。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int n1 = haystack.length();
        int n2 = needle.length();
        if (n2 > n1) {
            return -1;
        }
        for (int i = 0; i < n1 - n2 + 1; i++) {
            boolean flag = true;
            for (int j = 0; j < n2; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
