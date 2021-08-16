package y2021.m08.d14;

/**
 * @author ： cxyxh
 * @date : 8/14/2021 11:18 PM
 * @describetion :415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddStrings {

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        String res = addStrings(num1, num2);
        System.out.println(res);
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        if (n2 > n1) {
            return addStrings(num2, num1);
        }
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int num = 0;
        int index1 = n1 - 1;
        int index2 = n2 - 1;
        // 公共都有值的区域
        while (index1 >= 0 && index2 >= 0) {
            int i1 = num1.charAt(index1--) - '0';
            int i2 = num2.charAt(index2--) - '0';
            int sum = i1 + i2 + carry;
            num = sum % 10;
            carry = sum / 10;
            sb.append(num);
        }
        // 单独算n1的区域
        while (index1 >= 0) {
            int sum = num1.charAt(index1--) - '0' + carry;
            num = sum % 10;
            carry = sum / 10;
            sb.append(num);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
