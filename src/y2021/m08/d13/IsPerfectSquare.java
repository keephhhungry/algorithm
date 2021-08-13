package y2021.m08.d13;

/**
 * @author ： cxyxh
 * @date : 8/13/2021 10:45 PM
 * @describetion :367. 有效的完全平方数
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 * 示例 1：
 * 输入：num = 16
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：num = 14
 * 输出：false
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
        boolean res = isPerfectSquare(808201);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(logN)
     * 空间复杂度O(1)
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int left = 2;
        int right = num >> 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if ((long) mid * mid == num) {
                return true;
            } else if ((long) mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return false;
    }
}
