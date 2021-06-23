package y2021.m06.d15;

import java.time.temporal.Temporal;

/**
 * @author ： cxyxh
 * @date : 2021/6/17 23:31
 * @describetion : leetcode编号9-回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * <p>
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 示例 4：
 * 输入：x = -101
 * 输出：false
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Palindrome {

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println("结果为:[" + palindrome + "]");
    }

    /**
     * 时间复杂度：O(log n)，对于每次迭代，我们会将输入除以 10，因此时间复杂度为O(logn)。
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        // 负数和 整10的数(非0)的都不是回文数
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int num = 0;
        while (x > num) {
            int tmp = x % 10;
            num = num * 10 + tmp;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return num == x || num / 10 == x;
    }
}
