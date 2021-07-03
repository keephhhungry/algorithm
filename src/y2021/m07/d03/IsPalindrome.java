package y2021.m07.d03;

/**
 * @author ： cxyxh
 * @date : 2021/7/3 22:30
 * @describetion :leetcode编号125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean ans = isPalindrome(s);
        System.out.println(ans);
    }


    /**
     * 一次遍历
     * 思路：循环拿这个字符串的左字符和右字符作比较，如果字符不符合条件，那么移动角标继续拿下一个
     * 循环和获取字符过程中需要加上left<right的判断，如果一旦等于，那么说明之前的都是回文字符串，最后一个字符不影响结果
     * <p>
     * 时间复杂度：O(|s|)，其中 |s|是字符串 s 的长度。
     * 空间复杂度：O(1)。
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            // 左边的字符
            char c1 = s.charAt(left);
            while (left < right && !Character.isLetterOrDigit(c1)) {
                left++;
                c1 = s.charAt(left);
            }
            // 右边的字符
            char c2 = s.charAt(right);
            while (left < right && !Character.isLetterOrDigit(c2)) {
                right--;
                c2 = s.charAt(right);
            }
            // 如果两边字符不相等，那么返回false
            if (left < right && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
