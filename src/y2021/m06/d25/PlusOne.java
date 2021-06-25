package y2021.m06.d25;

import java.util.Arrays;

/**
 * @author ： cxyxh
 * @date : 2021/6/25 23:32
 * @describetion : leetcode编号66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * <p>
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * <p>
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 * <p>
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        digits = plusOne(digits);
        System.out.println(Arrays.toString(digits));

        digits = new int[]{8, 9, 9, 9};
        digits = plusOne(digits);
        System.out.println(Arrays.toString(digits));

        digits = new int[]{9, 9, 9, 9};
        digits = plusOne(digits);
        System.out.println(Arrays.toString(digits));
    }

    /**
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        for (int i = n; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newInt = new int[n + 2];
        newInt[0] = 1;
        return newInt;
    }
}
