package y2021.m09.d10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ： cxyxh
 * @date : 9/10/2021 3:47 PM
 * @describetion :728. 自除数
 * 自除数 是指可以被它包含的每一位数除尽的数。
 * 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 还有，自除数不允许包含 0 。
 * 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 上边界left = 1, 下边界right = 22
 * 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/self-dividing-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 每个输入参数的边界满足 1 <= left <= right <= 10000。
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        List<Integer> res = selfDividingNumbers(1, 22);
        res.stream().forEach(System.out::println);
    }

    /**
     * 时间复杂度O(NlogN)
     * 空间复杂度O(1)
     *
     * @param left
     * @param right
     * @return
     */
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        // 循环范围
        while (left <= right) {
            boolean flag = true;
            int num = left;

            //对每个数求结果
            while (num > 0) {
                // 求余数
                int remainder = num % 10;
                // 如果 余数是0并且当前数大于等于10(如10 20)   或者 余数不等于0  那么就不是自除数
                if ((remainder == 0 && num >= 10) || left % remainder != 0) {
                    flag = false;
                    break;
                }
                // 自除10
                num /= 10;
            }
            //  如果是自除数就添加
            if (flag == true) {
                res.add(left);
            }
            // 自增
            left++;
        }
        return res;
    }
}
