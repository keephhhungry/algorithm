package y2021.m06.d26;

/**
 * @author ： cxyxh
 * @date : 2021/6/24 23:48
 * @describetion :leetcode编号67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddBinary {

    // TODO 位运算解法不会
    public static void main(String[] args) {
        String a = "1010";
        String b = "1111";
        String s = addBinary2(a, b);
        System.out.println(s);
    }

    /**
     * 把二进制字符串转换成10进制整数相加，再转换成二进制字符串返回
     *
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }


    /**
     * 列竖式法
     * 时间复杂度：O(n)，这里的时间复杂度来源于顺序遍历 a 和 b。
     * 空间复杂度：O(1)，除去答案所占用的空间，这里使用了常数个临时变量。
     * @param a
     * @param b
     * @return
     */
    public static String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            // 如果没有超出字符串的限制，那么正常计算 '1' - '0' = 1 '0' - '0' = 0 ； 超出字符串限制则当0处理
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            // 如果carry是2，那么高位进1，该位为0；如果carry是1，那么该位为1
            ans.append((char) (carry % 2 + '0'));
            // 如果是2的话，carry等于1，高位往前进一位；如果是1，carry等于0，对高位无影响
            carry /= 2;
        }
        // 循环结束如果carry大于0，往前再进一位
        if (carry > 0) {
            ans.append('1');
        }
        // 由于我们添加的时候最末尾的值添加到最前面，最后需要进行一个字符串的反转
        ans.reverse();

        return ans.toString();
    }


}
