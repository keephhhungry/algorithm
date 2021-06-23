package y2021.m06.d14;

/**
 * @author ： cxyxh
 * @date : 2021/6/17 23:22
 * @describetion : leetcode编号7-整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * <p>
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * <p>
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * <p>
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 *  
 * 提示：
 * -2^31 <= x <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReverse {

    public static void main(String[] args) {
        int i = integerReverse(-321);
        System.out.println("反转后的值为：[" + i + "]");
    }

    /**
     * 时间复杂度：O(log |x|)。翻转的次数即 x 十进制的位数。
     * 空间复杂度：O(1)。
     * @param x
     * @return
     */
    public static int integerReverse(int x) {
        int num = 0;
        while (x != 0) {
            if (num < Integer.MIN_VALUE / 10 || num > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int tmp = x % 10;
            num = num * 10 + tmp;
            x = x / 10;
        }
        return num;
    }
}
