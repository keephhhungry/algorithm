package y2021.m09.d07;


/**
 * @author ： cxyxh
 * @date : 9/7/2021 11:31 PM
 * @describetion :709. 转换成小写字母
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 * <p>
 * 示例 1：
 * 输入：s = "Hello"
 * 输出："hello"
 * <p>
 * 示例 2：
 * 输入：s = "here"
 * 输出："here"
 * <p>
 * 示例 3：
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ToLowerCase {

    public static void main(String[] args) {
        String s = "Hello";
        String res = toLowerCase(s);
        System.out.println(res);
        //System.out.println((int) 'a');
        //System.out.println((int) 'z');
        //System.out.println((int) 'A');
        //System.out.println((int) 'Z');
    }

    /**
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param s
     * @return
     */
    public static String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] = (char) (chars[i] + 32);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
