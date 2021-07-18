package y2021.m07.d18;

import com.sun.media.sound.EmergencySoundbank;

/**
 * @author ： cxyxh
 * @date : 2021/7/18 9:45
 * @describetion :leetcode编号231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * <p>
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * <p>
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：n = 4
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：n = 5
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * -2^31 <= n <= 2^31 - 1
 * 进阶：你能够不使用循环/递归解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-two
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        boolean ans = isPowerOfTwo(16);
        System.out.println(ans);
    }


    /**
     * 位运算法
     * <p>
     * 时间复杂度：O(1)。
     * 空间复杂度：O(1)。
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
