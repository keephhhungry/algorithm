package y2021.m09.d16;

/**
 * @author ： cxyxh
 * @date : 9/15/2021 11:43 PM
 * @describetion :504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * 示例 1:
 * 输入: num = 100
 * 输出: "202"
 * <p>
 * 示例 2:
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/base-7
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertToBase7 {

    public static void main(String[] args) {
        String res = convertToBase7(4);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(logn)
     * 空间复杂度O(1)
     *
     * @param num
     * @return
     */
    public static String convertToBase7(int num) {
        if (num < 0)
            return "-" + convertToBase7(num * -1);
        if (num < 7)
            return num + "";
        return convertToBase7(num / 7) + convertToBase7(num % 7);
    }

}
