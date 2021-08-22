package y2021.m08.d21;

/**
 * @author ： cxyxh
 * @date : 8/21/2021 9:45 AM
 * @describetion :409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        int res = longestPalindrome("dccaccd");
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] arr = new int[128];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            arr[c] = arr[c] + 1;
        }

        int res = 0;
        for (int i : arr) {
            // 如果是3个，只能算2个
            res += i / 2 * 2;
            if (i % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }

        return res;
    }
}
