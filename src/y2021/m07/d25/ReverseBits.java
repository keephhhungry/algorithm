package y2021.m07.d25;

/**
 * @author ： cxyxh
 * @date : 7/25/2021 3:11 PM
 * @describetion :leetcode编号190. 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 示例 1：
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * 示例 2：
 * 输入：11111111111111111111111111111101
 * 输出：10111111111111111111111111111111
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 * <p>
 * 示例 1：
 * 输入：n = 00000010100101000001111010011100
 * 输出：964176192 (00111001011110000010100101000000)
 * 解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * 因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p>
 * 示例 2：
 * 输入：n = 11111111111111111111111111111101
 * 输出：3221225471 (10111111111111111111111111111111)
 * 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 *   因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *  
 * 提示：
 * <p>
 * 输入是一个长度为 32 的二进制字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBits {

    public static void main(String[] args) {
        int ans = reverseBits1(100);
        System.out.println(ans);
    }

    /**
     * 思路：每次把 res 左移，把 n 的二进制末尾数字，拼接到结果 res 的末尾。然后把 n 右移。
     * <p>
     * 时间复杂度O(1)
     * 空间复杂度O(1)
     *
     * @param n
     * @return
     */
    public static int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // res 每次左移一位，拼凑上 n的最右边一位
            res = (res << 1) | (n & 1);
            // n每次拼凑到最右一位后，往右移一位
            n >>= 1;
        }
        return res;
    }

}
