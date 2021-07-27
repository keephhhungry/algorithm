package y2021.m07.d27;

/**
 * @author ： cxyxh
 * @date : 7/27/2021 11:04 PM
 * @describetion :leetcode编号326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 *  
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 * <p>
 * 进阶：
 * <p>
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfThree {

    public static void main(String[] args) {
        boolean ans = isPowerOfThree1(6);
        System.out.println(ans);
        ans = isPowerOfThree2(9);
        System.out.println(ans);
    }

    /**
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree1(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    /**
     * int 上限承载为3的19次方。所以拿3的19次方处于n，如果可以整除说明可以被3整除
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfThree2(int n) {
        return n > 0 && Math.pow(3, 19) % 3 == 0;
    }
}
