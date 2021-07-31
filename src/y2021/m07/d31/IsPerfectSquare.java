package y2021.m07.d31;

/**
 * @author ： cxyxh
 * @date : 7/31/2021 11:55 PM
 * @describetion :367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPerfectSquare {

    public static void main(String[] args) {
        boolean ans = isPerfectSquare(16);
        System.out.println(ans);
    }

    /**
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

}
