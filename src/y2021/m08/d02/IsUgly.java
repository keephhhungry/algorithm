package y2021.m08.d02;

/**
 * @author ： cxyxh
 * @date : 8/2/2021 11:20 PM
 * @describetion :263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * <p>
 * 示例 2：
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 * <p>
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * <p>
 * 示例 4：
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 *  
 * 提示：
 * <p>
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsUgly {

    public static void main(String[] args) {
        boolean ans = isUgly(8);
        System.out.println(ans);
    }

    public static boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] arr = new int[]{2, 3, 5};
        for (int i : arr) {
            while (n % i == 0) {
                n /= i;
            }
        }
        return n == 1;
    }
}
